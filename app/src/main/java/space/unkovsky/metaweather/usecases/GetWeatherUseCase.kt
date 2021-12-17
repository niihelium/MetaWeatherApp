package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.entity.LocationWeather

interface GetWeatherUseCase {
    suspend operator fun invoke(woeid: Int): Result<LocationWeather>
}