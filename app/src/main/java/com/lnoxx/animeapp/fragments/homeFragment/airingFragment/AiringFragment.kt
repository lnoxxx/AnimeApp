package com.lnoxx.animeapp.fragments.homeFragment.airingFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnoxx.animeapp.R
import com.lnoxx.animeapp.databinding.FragmentAiringBinding
import com.lnoxx.animeapp.fragments.homeFragment.adapters.TopAnimeRecyclerViewAdapter
import com.lnoxx.animeapp.jikanAPI.JikanMainClass
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.Anime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AiringFragment : Fragment(),TopAnimeRecyclerViewAdapter.TopListListener {
    private lateinit var viewModel: AiringViewModel
    private lateinit var adapterTopAnime: TopAnimeRecyclerViewAdapter
    private lateinit var binding: FragmentAiringBinding

    private val topType = "airing"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AiringViewModel::class.java]
        binding = FragmentAiringBinding.inflate(inflater)

        binding.loadingAnimation3.playAnimation()

        binding.AiringRecyclerView.layoutManager = LinearLayoutManager(context)
        adapterTopAnime = TopAnimeRecyclerViewAdapter(mutableListOf(),this)
        binding.AiringRecyclerView.adapter = adapterTopAnime
        setTopList()
        return binding.root
    }

    private fun setTopList(){
        if (viewModel.top != null){
            val animeList = viewModel.top
            adapterTopAnime.addTopAnime(animeList!!.data)
            binding.loadingAnimation3.visibility = View.GONE
        } else {
            setAnimeTopInViewModel()
        }
    }

    private fun setAnimeTopInViewModel(){
        CoroutineScope(Dispatchers.IO).launch {
            val animeTopList = JikanMainClass().getAnimeTop(topType)
            viewModel.top = animeTopList
            withContext(Dispatchers.Main){
                adapterTopAnime.addTopAnime(animeTopList.data)
                binding.loadingAnimation3.visibility = View.GONE
            }
        }
    }

    override fun onOpenAnimeInfo(anime: Anime) {
        val bundle = Bundle()
        bundle.putInt("animeId",anime.mal_id)
        parentFragmentManager.setFragmentResult("openAnimeInfo",bundle)
        findNavController().navigate(R.id.action_homeFragment_to_animeViewFragment)
    }
}