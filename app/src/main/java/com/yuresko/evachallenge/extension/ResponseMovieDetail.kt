package com.yuresko.evachallenge.extension

import com.yuresko.evachallenge.data.models.ResponseMovieDetail
import com.yuresko.evachallenge.models.ModelMovieDetail

fun ResponseMovieDetail.toModelMovieDetail(): ModelMovieDetail {
    return ModelMovieDetail(
        description = this.plot
    )
}