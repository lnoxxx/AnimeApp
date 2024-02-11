package com.lnoxx.animeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lnoxx.animeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navInit()
    }
    private fun navInit(){
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment_container)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.searchFragment
            )
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.navController.setupWithNavController(navController)
    }
}