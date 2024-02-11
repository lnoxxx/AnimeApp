package com.lnoxx.animeapp.fragments.animeViewFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.lnoxx.animeapp.databinding.FragmentAnimeViewBinding
import com.lnoxx.animeapp.fragments.homeFragment.airingFragment.AiringViewModel

class AnimeViewFragment : Fragment() {
    private lateinit var viewModel: AnimeViewViewModel
    private lateinit var binding: FragmentAnimeViewBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeViewBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[AnimeViewViewModel::class.java]
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        parentFragmentManager
            .setFragmentResultListener("openAnimeInfo", this){ _, result ->
            viewModel.animeId = result.getInt("animeId")
        }
    }

    fun getAnimeInfo(){

    }
}