package space.unkovsky.metaweather.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import space.unkovsky.metaweather.data.remote.dto.LocationDto
import space.unkovsky.metaweather.data.remote.dto.LocationSearchDto

interface MetaWeatherApiService {
    @GET("api/location/search/")
    suspend fun locationSearch(@Query("query") location: String): Response<List<LocationSearchDto>>

    @GET("api/location/{woeid}/")
    suspend fun locationWeather(@Path("woeid") woeid: Int): Response<LocationDto>

    @GET("/static/img/weather/{id}.svg")
    suspend fun weatherIcon(@Path("id") weatherStateAbbr: String): Response<ByteArray>
}