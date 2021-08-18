package com.yuresko.evachallenge.ui.searchmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.yuresko.evachallenge.data.PageSourceMovies
import com.yuresko.evachallenge.data.Repository
import com.yuresko.evachallenge.data.local.AppDatabase
import com.yuresko.evachallenge.models.ModelMovie
import com.yuresko.evachallenge.utils.DispatcherProvider
import com.yuresko.evachallenge.utils.PER_PAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val db: AppDatabase,
    private val repository: Repository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    fun markAsWatched(movie: ModelMovie) {
        viewModelScope.launch(dispatchers.io) {
            db.repo().insertMovie(movie)
        }
    }

    fun searchByTitle(title: String): Flow<PagingData<ModelMovie>> {
        return Pager(
            PagingConfig(enablePlaceholders = false, pageSize = PER_PAGE), pagingSourceFactory = {
                PageSourceMovies(repository, title)
            }).flow.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
    }
}