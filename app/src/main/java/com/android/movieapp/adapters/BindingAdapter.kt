package com.android.movieapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.android.movieapp.MovieApp
import com.bumptech.glide.Glide

class BindingAdapter {
    companion object{

        @JvmStatic
        @BindingAdapter("loadImage")
        fun setLoadImage(view: ImageView?, url: String?) {
            Glide.with(MovieApp.instance).load(url).into(view!!)
        }

    }

}