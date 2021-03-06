package space.unkovsky.metaweather.data.remote

import retrofit2.Response
import space.unkovsky.metaweather.data.remote.dto.LocationDto
import space.unkovsky.metaweather.data.remote.dto.LocationSearchDto
import javax.inject.Inject

class MetaWeatherRetrofitApi @Inject constructor(
    private val apiService: MetaWeatherApiService,
) : MetaWeatherApi {
    override suspend fun locationSearch(query: String): Response<List<LocationSearchDto>> {
        return apiService.locationSearch(query)
    }

    override suspend fun locationWeather(woeid: Int): Response<LocationDto> {
        return apiService.locationWeather(woeid)
    }
}