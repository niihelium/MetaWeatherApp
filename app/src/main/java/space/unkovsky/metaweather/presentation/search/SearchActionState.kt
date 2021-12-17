package space.unkovsky.metaweather.presentation.search

import space.unkovsky.metaweather.data.local.entity.Location
import space.unkovsky.metaweather.presentation.Action
import space.unkovsky.metaweather.presentation.State

sealed class SearchViewState : State {
    object Empty : SearchViewState()
    data class Locations(val locations: List<Location>) : SearchViewState()
}

sealed class SearchAction : Action {
    data class Search(val query: String) : SearchAction()
}