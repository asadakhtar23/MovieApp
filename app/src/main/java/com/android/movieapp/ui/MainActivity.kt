package com.android.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.android.movieapp.R
import com.android.movieapp.databinding.ActivityMainBinding
import com.android.movieapp.viewmodels.MainViewModel
import com.movieapp.core.models.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpOnDataChangeObserver()
        mainViewModel.fetchMoviesByCategory("")
    }

    private fun setUpOnDataChangeObserver() {
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {

                }
                is NetworkResult.Error -> {

                }
                is NetworkResult.Loading -> {

                }
            }
        }
    }
}