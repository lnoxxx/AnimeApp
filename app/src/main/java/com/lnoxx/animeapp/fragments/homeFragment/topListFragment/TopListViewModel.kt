package com.lnoxx.animeapp.fragments.homeFragment.topListFragment

import androidx.lifecycle.ViewModel
import com.lnoxx.animeapp.jikanAPI.jikanDataClasses.AnimeTopResponse

class TopListViewModel : ViewModel() {
    var top: AnimeTopResponse? = null
}