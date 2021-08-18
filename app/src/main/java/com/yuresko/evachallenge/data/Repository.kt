package com.yuresko.evachallenge.data

import com.yuresko.evachallenge.data.remote.ResponseResult
import com.yuresko.evachallenge.models.ModelMovie

interface Repository {

    suspend fun getSearchMovie(name: String, page: Int): ResponseResult<List<ModelMovie>>

}