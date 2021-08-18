package com.yuresko.evachallenge.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yuresko.evachallenge.ui.searchmovie.SearchMovieFragment
import com.yuresko.evachallenge.ui.watched.WatchedFragment
import com.yuresko.evachallenge.ui.watchlater.WatchLaterFragment

const val SEARCH_MOVIE_INDEX = 0
const val WATCHED_MOVIE_INDEX = 1
const val WATCH_LATER_INDEX = 2

class HomeViewPager(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        SEARCH_MOVIE_INDEX to { SearchMovieFragment() },
        WATCHED_MOVIE_INDEX to { WatchedFragment() },
        WATCH_LATER_INDEX to { WatchLaterFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}