package com.lnoxx.animeapp.fragments.animeViewFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.lnoxx.animeapp.databinding.FragmentAnimeViewBinding
import com.lnoxx.animeapp.fragments.SharedViewModel
import com.lnoxx.animeapp.jikanAPI.JikanMainClass
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeData
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnimeViewFragment : Fragment() {
    private lateinit var viewModel: AnimeViewViewModel
    private lateinit var binding: FragmentAnimeViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeViewBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[AnimeViewViewModel::class.java]
        val sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        viewModel.animeId = sharedViewModel.animeIdOpenFull
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.animeId?.let { setAnimeInfo(it) }
    }

    private fun setAnimeInfo(animeId: Int){
        CoroutineScope(Dispatchers.IO).launch {
            val animeInfo = JikanMainClass.getFullAnimeInfo(animeId)
            withContext(Dispatchers.Main){
                bindAnimeInfo(animeInfo.data)
            }
        }
    }

    fun onClickOpenSynopsys(view: View){

    }

    private fun bindAnimeInfo(animeInfo: AnimeData){
        Picasso.get().load(animeInfo.images.jpg.large_image_url).into(binding.animeViewImage)
        Picasso.get().load(animeInfo.images.jpg.large_image_url).into(binding.backgroundAnime)
        binding.apply {
            animeViewTitle.text = animeInfo.title
            raiting.text = animeInfo.rating
            val seasonYearText = animeInfo.year.toString() + " " + animeInfo.season
            seasonYear.text = seasonYearText
            val episodeTimingText = animeInfo.episodes.toString() + " | " + animeInfo.duration + "."
            episodeTiming.text = episodeTimingText
            val statusTypeText = animeInfo.type + " | " + animeInfo.status
            statusType.text = statusTypeText
            studios.text = animeInfo.studios[0].toString()
            synopsis.text = animeInfo.synopsis
        }
    }
}

//                Log.d("mylog","image " + animeInfo.data.images.jpg.large_image_url)
//                Log.d("mylog","title " + animeInfo.data.title)
//                Log.d("mylog","rating " + animeInfo.data.rating)
//
//                Log.d("mylog","season " + animeInfo.data.season)
//                Log.d("mylog","year " + animeInfo.data.year)
//
//                Log.d("mylog","episodes " + animeInfo.data.episodes)
//                Log.d("mylog","duration " + animeInfo.data.duration)
//
//                Log.d("mylog","type " + animeInfo.data.type)
//                Log.d("mylog","status " + animeInfo.data.status)
//
//                for (studios in animeInfo.data.studios){
//                    Log.d("mylog","studos: " + studios)
//                }
//
//                for (genre in animeInfo.data.genres){
//                    Log.d("mylog","gener: " + genre)
//                }
//
//                Log.d("mylog","synopsis " + animeInfo.data.synopsis)
//
//                Log.d("mylog","trailerImg " + animeInfo.data.trailer.images.large_image_url)
//                Log.d("mylog","trailerUrl " + animeInfo.data.trailer.url)
//
//                for (opening in animeInfo.data.theme.openings){
//                    Log.d("mylog","openings: " + opening)
//                }
//                for (ending in animeInfo.data.theme.endings){
//                    Log.d("mylog","endings: " + ending)
//                }
//
//                Log.d("mylog","score " + animeInfo.data.score)
//                Log.d("mylog","score by " + animeInfo.data.scored_by)
//                Log.d("mylog","popularity " + animeInfo.data.popularity)
//                Log.d("mylog","favorites " + animeInfo.data.favorites)