package com.lnoxx.animeapp.fragments.homeFragment.topListFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.LottieDrawable
import com.lnoxx.animeapp.R
import com.lnoxx.animeapp.databinding.FragmentToplistBinding
import com.lnoxx.animeapp.fragments.SharedViewModel
import com.lnoxx.animeapp.fragments.homeFragment.adapters.TopAnimeRecyclerViewAdapter
import com.lnoxx.animeapp.jikanAPI.JikanMainClass
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.Anime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopListFragment(private val topType: String):
    Fragment(),TopAnimeRecyclerViewAdapter.TopListListener {
    private lateinit var viewModel: TopListViewModel
    private lateinit var adapterTopAnime: TopAnimeRecyclerViewAdapter
    private lateinit var binding: FragmentToplistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[TopListViewModel::class.java]
        binding = FragmentToplistBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationStartStop(true)
        binding.AiringRecyclerView.layoutManager = LinearLayoutManager(context)
        CoroutineScope(Dispatchers.IO).launch {
            adapterTopAnime = getAnimeListAdapter()
            withContext(Dispatchers.Main){
                binding.AiringRecyclerView.adapter = adapterTopAnime
                animationStartStop(false)
            }
        }
    }

    private fun animationStartStop(status: Boolean){
        val loadingAnimationView = binding.loadingAnimation3
        if (status){
            loadingAnimationView.repeatCount = LottieDrawable.INFINITE
            loadingAnimationView.playAnimation()
        } else{
            loadingAnimationView.cancelAnimation()
            binding.loadingAnimation3.visibility = View.GONE
        }
    }

    private suspend fun getAnimeListAdapter(): TopAnimeRecyclerViewAdapter{
        return if (viewModel.top != null){
            val animeList = viewModel.top
            TopAnimeRecyclerViewAdapter(animeList!!.data,this)
        } else {
            val animeList = JikanMainClass.getAnimeTop(topType)
            viewModel.top = animeList
            TopAnimeRecyclerViewAdapter(animeList.data,this)
        }
    }

    override fun onOpenAnimeInfo(anime: Anime) {
        val sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        sharedViewModel.animeIdOpenFull = anime.mal_id
        findNavController().navigate(R.id.action_homeFragment_to_animeViewFragment)
    }
}