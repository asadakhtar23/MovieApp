package com.android.movieapp.ui

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

open class BaseActivity: AppCompatActivity() {
    fun showSnackBar(view:View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
}