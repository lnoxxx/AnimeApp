package com.lnoxx.animeapp.fragments.homeFragment.popylarityFragment

import androidx.lifecycle.ViewModel
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse

class PopularityViewModel : ViewModel() {
    var top: AnimeTopResponse? = null
}