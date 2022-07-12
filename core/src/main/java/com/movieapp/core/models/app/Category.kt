package com.movieapp.core.models.app

import com.movieapp.core.models.category.Results

data class Category(var name: String,
                    var slug:String,
                    var movieList: List<Results>? = null,
                    var loadInitially: Boolean = false,
                    var isExpandable: Boolean = false)