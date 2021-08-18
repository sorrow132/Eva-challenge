package com.yuresko.evachallenge.extension

import com.yuresko.evachallenge.data.models.ResponseSearchMovie
import com.yuresko.evachallenge.models.ModelMovie

fun ResponseSearchMovie.toModelMovie(): List<ModelMovie> {
    return this.search.map { item ->
        ModelMovie(
            id = item.imdbID,
            name = item.title,
            year = item.year,
            poster = item.poster
        )
    }
}
