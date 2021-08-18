package com.yuresko.evachallenge.data.models

import com.google.gson.annotations.SerializedName

data class ResponseSearchMovie(
    @SerializedName("Search") var search: List<SearchItem>
)

data class SearchItem(
    @SerializedName("Type")
    var type: String,

    @SerializedName("Year")
    var year: String,

    @SerializedName("imdbID")
    var imdbID: String,

    @SerializedName("Poster")
    var poster: String,

    @SerializedName("Title")
    var title: String
)
