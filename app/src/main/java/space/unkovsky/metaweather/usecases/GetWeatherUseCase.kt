package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.LocationWeather

interface GetWeatherUseCase {
    suspend operator fun invoke(woeid: Int): Result<LocationWeather>
}