package com.yuresko.evachallenge.ui.watched

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuresko.evachallenge.data.local.AppDatabase
import com.yuresko.evachallenge.data.remote.ResponseResult
import com.yuresko.evachallenge.models.ModelMovie
import com.yuresko.evachallenge.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchedViewModel @Inject constructor(
    private val db: AppDatabase,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _loadingMovie: MutableStateFlow<Flow<ModelMovie>?> = MutableStateFlow(null)
    val loadingMovie = _loadingMovie.asStateFlow()

    init {
        showWatchedData()
    }

    private fun showWatchedData() {
        viewModelScope.launch(dispatchers.io) {
            _loadingMovie.value = db.repo().getWatchedMovie()
        }
    }

}