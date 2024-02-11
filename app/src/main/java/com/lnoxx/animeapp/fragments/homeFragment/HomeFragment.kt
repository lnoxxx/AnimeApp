package com.lnoxx.animeapp.fragments.homeFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.lnoxx.animeapp.databinding.FragmentHomeBinding
import com.lnoxx.animeapp.fragments.homeFragment.adapters.HomeViewPagerAdapter
import com.lnoxx.animeapp.fragments.homeFragment.airingFragment.AiringFragment
import com.lnoxx.animeapp.fragments.homeFragment.popylarityFragment.PopularityFragment
import com.lnoxx.animeapp.fragments.homeFragment.raitingFragment.RatingFragment
import com.lnoxx.animeapp.fragments.homeFragment.upcomingFragment.UpcomingFragment
import com.lnoxx.animeapp.jikanAPI.JikanMainClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding = FragmentHomeBinding.inflate(inflater)

        val adapter = HomeViewPagerAdapter(childFragmentManager,lifecycle)
        binding.HomeViewPager.adapter = adapter

        TabLayoutMediator(binding.HomeTabLayout,binding.HomeViewPager){ tab, position ->
            tab.text = when(position){
                0 -> "Онгоинги"
                1 -> "Анонсы"
                2 -> "Популярные"
                3 -> "Лучшие"
                else -> null
            }
        }.attach()

        return binding.root
    }
}