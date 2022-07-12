package com.android.movieapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
        var showProgressDialog = MutableLiveData<Boolean>()
        var showErrorMessage = MutableLiveData<String>()
}