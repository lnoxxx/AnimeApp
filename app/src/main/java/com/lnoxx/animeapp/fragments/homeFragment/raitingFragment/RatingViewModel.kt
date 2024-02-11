package com.lnoxx.animeapp.fragments.homeFragment.raitingFragment

import androidx.lifecycle.ViewModel
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse

class RatingViewModel : ViewModel() {
    var top: AnimeTopResponse? = null
}