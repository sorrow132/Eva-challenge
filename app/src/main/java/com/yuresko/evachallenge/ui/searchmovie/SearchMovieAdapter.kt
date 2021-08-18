package com.yuresko.evachallenge.ui.searchmovie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.yuresko.evachallenge.databinding.ListItemMovieSearchBinding
import com.yuresko.evachallenge.models.ModelMovie

class SearchMovieAdapter(
    private val onAddWatched: (ModelMovie) -> Unit,
    private val onRemoveWatched: (ModelMovie) -> Unit
) : PagingDataAdapter<ModelMovie, SearchMovieViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        return SearchMovieViewHolder(
            ListItemMovieSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onAddWatched,
            onRemoveWatched
        )
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
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