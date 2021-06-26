package space.unkovsky.metaweather.data.remote

import retrofit2.Response
import space.unkovsky.metaweather.data.remote.dto.LocationSearchDto
import javax.inject.Inject

class MetaWeatherRetrofitApi @Inject constructor(
    val apiService: MetaWeatherApiService
) : MetaWeatherApi {
    override suspend fun locationSearch(location: String): Response<List<LocationSearchDto>> {
        return apiService.locationSearch(location)
    }
}