package com.yuresko.evachallenge.ui.watched

import androidx.recyclerview.widget.RecyclerView
import com.yuresko.evachallenge.databinding.ListItemMovieWatchedBinding
import com.yuresko.evachallenge.models.ModelMovie

class WatchedMoviesViewHolder(private val binding: ListItemMovieWatchedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(modelMovie: ModelMovie) {
        binding.movieWatchedName.text = modelMovie.name
    }
}