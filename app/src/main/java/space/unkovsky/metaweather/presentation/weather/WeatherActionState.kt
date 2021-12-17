package space.unkovsky.metaweather.presentation.weather

import space.unkovsky.metaweather.data.local.entity.LocationWeather
import space.unkovsky.metaweather.presentation.Action
import space.unkovsky.metaweather.presentation.State

sealed class WeatherViewState : State {
    object Empty : WeatherViewState()
    data class Weather(val locationWeather: LocationWeather) : WeatherViewState()
}

sealed class WeatherAction : Action {
    data class WeatherRequest(val woeid: Int) : WeatherAction()
}