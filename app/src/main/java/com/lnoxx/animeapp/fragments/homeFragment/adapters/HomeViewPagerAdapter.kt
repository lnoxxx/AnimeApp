package com.lnoxx.animeapp.fragments.homeFragment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lnoxx.animeapp.fragments.homeFragment.airingFragment.AiringFragment
import com.lnoxx.animeapp.fragments.homeFragment.popylarityFragment.PopularityFragment
import com.lnoxx.animeapp.fragments.homeFragment.raitingFragment.RatingFragment
import com.lnoxx.animeapp.fragments.homeFragment.upcomingFragment.UpcomingFragment

class HomeViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fragmentManager, lifecycle){
    private val pageNumbers = 4
    override fun getItemCount(): Int {
        return pageNumbers
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> AiringFragment()
            1 -> UpcomingFragment()
            2 -> PopularityFragment()
            3 -> RatingFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}