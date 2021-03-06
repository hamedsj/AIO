package com.worldsnas.home

import com.worldsnas.base.BaseState
import com.worldsnas.base.BaseViewState
import com.worldsnas.home.model.HomeUIModel
import com.worldsnas.home.model.MovieUIModel
import com.worldsnas.view_component.Movie

data class HomeState(
    override val base: BaseState,
    val sliderMovies: List<Movie>,
    val latest: List<Movie>,
    val homeItems : List<HomeUIModel>
) : BaseViewState {
    companion object {
        fun start() = HomeState(
            base = BaseState.stable(),
            sliderMovies = emptyList(),
            latest = emptyList(),
            homeItems = emptyList())
    }
}