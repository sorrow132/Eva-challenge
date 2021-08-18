package com.yuresko.evachallenge.data

import com.yuresko.evachallenge.data.remote.OMDbService
import com.yuresko.evachallenge.data.remote.ResponseResult
import com.yuresko.evachallenge.extension.toModelMovie
import com.yuresko.evachallenge.extension.toModelMovieDetail
import com.yuresko.evachallenge.models.ModelMovie
import com.yuresko.evachallenge.utils.API_KEY
import com.yuresko.evachallenge.utils.DispatcherProvider
import com.yuresko.evachallenge.utils.NotFoundException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: OMDbService,
    private val dispatchers: DispatcherProvider
) : Repository {

    override suspend fun getSearchMovie(name: String, page: Int): ResponseResult<List<ModelMovie>> {
        return withContext(dispatchers.io) {
            try {
                service.getSearchResultData(name, API_KEY, page).body()?.toModelMovie()
                    ?.let { models ->
                        ResponseResult.Success(models)
                    } ?: ResponseResult.Success(emptyList())
            } catch (ex: Exception) {
                ResponseResult.Error(ex)
            }
        }
    }

    suspend fun getMovieDetails(title: String) =
        flow {
            try {
                service.getMovieDetailData(title, API_KEY).body()?.toModelMovieDetail()
                    ?.let { model -> emit(ResponseResult.Success(model)) }
                    ?: throw NotFoundException()
            } catch (ex: Exception) {
                emit(ResponseResult.Error(ex))
            }
        }
}