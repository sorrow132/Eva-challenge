package com.yuresko.evachallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.yuresko.evachallenge.databinding.ListItemMovieSearchBinding
import com.yuresko.evachallenge.models.ModelMovie

class MoviesAdapter : PagingDataAdapter<ModelMovie, MoviesViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            ListItemMovieSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
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