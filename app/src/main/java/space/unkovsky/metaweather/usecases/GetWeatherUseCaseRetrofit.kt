package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.LocationWeather
import space.unkovsky.metaweather.data.remote.MetaWeatherApi
import space.unkovsky.metaweather.data.remote.dto.toLocationWeather
import space.unkovsky.metaweather.getApiResult
import javax.inject.Inject

class GetWeatherUseCaseRetrofit @Inject constructor(
    private val api: MetaWeatherApi
) : GetWeatherUseCase {
    override suspend operator fun invoke(woeid: Int): Result<LocationWeather> {
        return getApiResult { api.locationWeather(woeid) }.map { it.toLocationWeather() }
    }
}