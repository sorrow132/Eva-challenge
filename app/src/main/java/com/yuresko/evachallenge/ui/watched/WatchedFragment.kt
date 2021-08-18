package com.yuresko.evachallenge.ui.watched

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yuresko.evachallenge.databinding.FragmentWatchedMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.toList

@AndroidEntryPoint
class WatchedFragment : Fragment() {

    private val viewModel: WatchedViewModel by viewModels()
    private lateinit var binding: FragmentWatchedMovieBinding
    private val adapter = WatchedMoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWatchedMovieBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.recyclerViewWatched.adapter = adapter

        lifecycleScope.launchWhenStarted {
            adapter.submitList(viewModel.loadingMovie.value?.toList())
        }

        return binding.root
    }

}