package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.Location
import space.unkovsky.metaweather.data.local.LocationWeather
import space.unkovsky.metaweather.data.remote.dto.WeatherDto

interface GetWeatherUseCase {
    suspend fun getWeather(woeid: Int): LocationWeather
}