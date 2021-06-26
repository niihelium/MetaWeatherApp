package space.unkovsky.metaweather.data.remote

import retrofit2.Response
import space.unkovsky.metaweather.data.remote.dto.LocationSearchDto

interface MetaWeatherApi {
    suspend fun locationSearch(location: String): Response<List<LocationSearchDto>>
}