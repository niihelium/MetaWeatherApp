package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.LocationWeather
import space.unkovsky.metaweather.data.remote.MetaWeatherApi
import space.unkovsky.metaweather.data.remote.dto.toLocationWeather
import javax.inject.Inject

class GetWeatherUseCaseRetrofit @Inject constructor(
    private val api: MetaWeatherApi
) : GetWeatherUseCase {
    override suspend operator fun invoke(woeid: Int): LocationWeather {
        val response = api.locationWeather(woeid)
        return if (response.isSuccessful) {
            response.body()?.toLocationWeather() ?: LocationWeather()
        } else {
            LocationWeather()
        }
    }
}