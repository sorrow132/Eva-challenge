package com.yuresko.evachallenge.ui.searchmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.yuresko.evachallenge.databinding.FragmentMovieSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchMovieFragment : Fragment() {

    private val viewModel: SearchMovieViewModel by viewModels()
    private lateinit var binding: FragmentMovieSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)

        val adapter = SearchMovieAdapter(
            onAddWatched = {
                viewModel.markAsWatched(it)
            },
            onRemoveWatched = {
                viewModel.markAsWatched(it)
            }
        )
        binding.recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.searchByTitle("Batman")
                .collectLatest(adapter::submitData)
        }

        return binding.root
    }
}