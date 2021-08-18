package com.yuresko.evachallenge.ui.searchmovie

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yuresko.evachallenge.databinding.ListItemMovieSearchBinding
import com.yuresko.evachallenge.models.ModelMovie

class SearchMovieViewHolder(
    private val binding: ListItemMovieSearchBinding,
    private val onAddWatched: (ModelMovie) -> Unit,
    private val onRemoveWatched: (ModelMovie) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(model: ModelMovie) {
        binding.movieSearchName.text = model.name

        Glide.with(binding.movieSearchPoster)
            .load(model.poster)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.movieSearchPoster)

        binding.addToWatched.setOnClickListener {
            onAddWatched(model)
        }
    }
}
