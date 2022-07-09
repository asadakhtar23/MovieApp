package com.movieapp.core.models.category

import com.google.gson.annotations.SerializedName

data class MovieCategoryResponse (
    @SerializedName("dates" ) var dates: Dates? = Dates(),
    @SerializedName("page") var page : Int? = null,
    @SerializedName("results" ) var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("total_pages" ) var totalPages : Int? = null,
    @SerializedName("total_results" ) var totalResults : Int? = null
)