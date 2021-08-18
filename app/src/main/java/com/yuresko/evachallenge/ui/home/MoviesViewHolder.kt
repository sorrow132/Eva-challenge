package com.yuresko.evachallenge.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yuresko.evachallenge.databinding.ListItemMovieSearchBinding
import com.yuresko.evachallenge.models.ModelMovie

class MoviesViewHolder(private val binding: ListItemMovieSearchBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ModelMovie) {
        binding.movieSearchName.text = model.name

        Glide.with(binding.movieSearchPoster)
            .load(model.poster)
            .into(binding.movieSearchPoster)
    }
}
