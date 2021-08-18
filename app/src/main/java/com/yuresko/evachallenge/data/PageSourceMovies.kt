package com.yuresko.evachallenge.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yuresko.evachallenge.extension.pagingSucceeded
import com.yuresko.evachallenge.models.ModelMovie

class PageSourceMovies(
    private val repository: Repository,
    private val query: String
) : PagingSource<Int, ModelMovie>() {

    override fun getRefreshKey(state: PagingState<Int, ModelMovie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ModelMovie> {
        val page = params.key ?: 1
        return repository.getSearchMovie(query, page).pagingSucceeded { data ->
            LoadResult.Page(
                data = data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.isEmpty()) null else page.plus(1)
            )
        }
    }
}