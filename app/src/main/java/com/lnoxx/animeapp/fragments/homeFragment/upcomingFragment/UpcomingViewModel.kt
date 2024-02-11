package com.lnoxx.animeapp.fragments.homeFragment.upcomingFragment

import androidx.lifecycle.ViewModel
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse

class UpcomingViewModel : ViewModel() {
    var top: AnimeTopResponse? = null
}