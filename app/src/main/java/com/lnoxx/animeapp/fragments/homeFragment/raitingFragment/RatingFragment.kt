package com.lnoxx.animeapp.fragments.homeFragment.raitingFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnoxx.animeapp.databinding.FragmentRatingBinding
import com.lnoxx.animeapp.fragments.homeFragment.adapters.TopAnimeRecyclerViewAdapter
import com.lnoxx.animeapp.jikanAPI.JikanMainClass
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.Anime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RatingFragment : Fragment(),TopAnimeRecyclerViewAdapter.TopListListener {
    private lateinit var viewModel: RatingViewModel
    private lateinit var adapterTopAnime: TopAnimeRecyclerViewAdapter
    private lateinit var binding: FragmentRatingBinding

    private val topType = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[RatingViewModel::class.java]
        binding = FragmentRatingBinding.inflate(inflater)

        binding.loadingAnimation.playAnimation()

        binding.RaitingRecyclerView.layoutManager = LinearLayoutManager(context)
        adapterTopAnime = TopAnimeRecyclerViewAdapter(mutableListOf(),this)
        binding.RaitingRecyclerView.adapter = adapterTopAnime
        setTopList()
        return binding.root
    }

    private fun setTopList(){
        if (viewModel.top != null){
            val animeList = viewModel.top
            adapterTopAnime.addTopAnime(animeList!!.data)
            binding.loadingAnimation.visibility = View.GONE
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
                binding.loadingAnimation.visibility = View.GONE
            }
        }
    }

    override fun onOpenAnimeInfo(anime: Anime) {

    }
}