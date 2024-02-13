package com.lnoxx.animeapp.fragments.homeFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.lnoxx.animeapp.R
import com.lnoxx.animeapp.databinding.FragmentHomeBinding
import com.lnoxx.animeapp.fragments.homeFragment.adapters.HomeViewPagerAdapter

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
                0 -> getString(R.string.airing_title)
                1 -> getString(R.string.upcoming_title)
                2 -> getString(R.string.popularity_title)
                3 -> getString(R.string.rating_title)
                else -> null
            }
        }.attach()

        return binding.root
    }
}