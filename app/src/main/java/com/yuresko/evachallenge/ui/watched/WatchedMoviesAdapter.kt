package com.yuresko.evachallenge.ui.watched

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yuresko.evachallenge.databinding.ListItemMovieWatchedBinding
import com.yuresko.evachallenge.models.ModelMovie

class WatchedMoviesAdapter : ListAdapter<ModelMovie, WatchedMoviesViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchedMoviesViewHolder {
        return WatchedMoviesViewHolder(
            ListItemMovieWatchedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WatchedMoviesViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<ModelMovie>() {
        override fun areItemsTheSame(oldItem: ModelMovie, newItem: ModelMovie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ModelMovie, newItem: ModelMovie): Boolean {
            return oldItem == newItem
        }
    }
}