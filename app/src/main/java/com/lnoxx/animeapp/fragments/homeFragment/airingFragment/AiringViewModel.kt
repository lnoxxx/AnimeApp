package com.lnoxx.animeapp.fragments.homeFragment.airingFragment

import androidx.lifecycle.ViewModel
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse

class AiringViewModel : ViewModel() {
    var top: AnimeTopResponse? = null
}