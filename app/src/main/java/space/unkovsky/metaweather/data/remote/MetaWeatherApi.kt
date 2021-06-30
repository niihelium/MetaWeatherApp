package space.unkovsky.metaweather.data.remote

import retrofit2.Response
import space.unkovsky.metaweather.data.remote.dto.LocationDto
import space.unkovsky.metaweather.data.remote.dto.LocationSearchDto

interface MetaWeatherApi {
    suspend fun locationSearch(query: String): Response<List<LocationSearchDto>>
    suspend fun locationWeather(woeid: Int): Response<LocationDto>
}