package space.unkovsky.metaweather.presentation.weather

import space.unkovsky.metaweather.data.local.LocationWeather
import space.unkovsky.metaweather.presentation.Action
import space.unkovsky.metaweather.presentation.State

sealed class WeatherViewState : State {
    data class Weather(val loccationWeather: LocationWeather) : WeatherViewState()
}

sealed class WeatherAction : Action {
    data class WeatherRequest(val woeid: Int) : WeatherAction()
}