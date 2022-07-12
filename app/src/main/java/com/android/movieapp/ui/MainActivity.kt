package com.android.movieapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.movieapp.R
import com.android.movieapp.adapters.CategoryAdapter
import com.android.movieapp.bloc.states.MovieDetailsStates
import com.android.movieapp.databinding.ActivityMainBinding
import com.android.movieapp.databinding.BottomSheetBinding
import com.android.movieapp.viewmodels.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.movieapp.core.models.details.MovieDetailResponse
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rvCategory.layoutManager = LinearLayoutManager(this)
        binding.clProgress.visibility = View.GONE
        setUpOnDataChangeObserver()
        mainViewModel.initCategoryList()
    }

    private fun setUpOnDataChangeObserver() {
        mainViewModel.responseMoviesByCategory.observe(this) { data ->
            val adapter = CategoryAdapter(data, mainViewModel)
            binding.rvCategory.adapter = adapter
        }

        mainViewModel.responseMovieDetails.observe(this) { state ->
            when (state) {
                is MovieDetailsStates.MovieDetailsFetched -> {
                    binding.clProgress.visibility = View.GONE
                    showBottomSheetDialog(state.data)
                    Log.e("response", state.data.toString())
                }
                is MovieDetailsStates.Error -> {
                    binding.clProgress.visibility = View.GONE
                    showSnackBar(binding.clRoot, state.message)
                }
                is MovieDetailsStates.Loading -> {
                    binding.clProgress.visibility = View.VISIBLE
                }
            }
        }

        mainViewModel.showErrorMessage.observe(this) { message ->
            showSnackBar(binding.clRoot, message)
        }
    }

    private fun showBottomSheetDialog(movieDetailResponse: MovieDetailResponse) {

        val bottomSheet = BottomSheetDialog(this@MainActivity)
        val bindingSheet = DataBindingUtil.inflate<BottomSheetBinding>(
            layoutInflater,
            R.layout.bottom_sheet,
            null,
            false
        )
        bottomSheet.setContentView(bindingSheet.root)

        bindingSheet.movieDetail = movieDetailResponse

        if(movieDetailResponse.video == true) {
            bindingSheet.ivVideoPlayer.visibility = View.VISIBLE
        } else {
            bindingSheet.ivVideoPlayer.visibility = View.GONE
        }

        bindingSheet.ivVideoPlayer.setOnClickListener {
            bottomSheet.hide()
            showSnackBar(binding.clRoot, movieDetailResponse.title!!)
        }

        bottomSheet.show()
    }
}