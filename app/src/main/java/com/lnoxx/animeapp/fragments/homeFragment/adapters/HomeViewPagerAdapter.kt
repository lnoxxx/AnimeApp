package com.lnoxx.animeapp.fragments.homeFragment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lnoxx.animeapp.fragments.homeFragment.TopTypesConst
import com.lnoxx.animeapp.fragments.homeFragment.topListFragment.TopListFragment

class HomeViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle){
    private val pageNumbers = 4
    override fun getItemCount(): Int {
        return pageNumbers
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TopListFragment(TopTypesConst.airing)
            1 -> TopListFragment(TopTypesConst.upcoming)
            2 -> TopListFragment(TopTypesConst.byPopularity )
            3 -> TopListFragment(TopTypesConst.byRating)
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}