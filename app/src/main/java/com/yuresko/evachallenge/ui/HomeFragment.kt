package com.yuresko.evachallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.yuresko.evachallenge.R
import com.yuresko.evachallenge.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = HomeViewPager(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            SEARCH_MOVIE_INDEX -> R.drawable.ic_baseline_search_24
            WATCHED_MOVIE_INDEX -> R.drawable.ic_baseline_remove_red_eye_24
            WATCH_LATER_INDEX -> R.drawable.ic_baseline_watch_later_24
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            SEARCH_MOVIE_INDEX -> getString(R.string.tab_search)
            WATCHED_MOVIE_INDEX -> getString(R.string.tab_watched)
            WATCH_LATER_INDEX -> getString(R.string.tab_watch_later)
            else -> null
        }
    }
}