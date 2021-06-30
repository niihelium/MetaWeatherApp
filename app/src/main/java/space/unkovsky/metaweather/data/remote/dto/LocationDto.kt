package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName
import space.unkovsky.metaweather.data.local.Entity.LocationWeather

data class LocationDto(
    @SerializedName("consolidated_weather")
    val weather: List<WeatherDto>,
    @SerializedName("title")
    val title: String
)

fun LocationDto.toLocationWeather(): LocationWeather {

    return LocationWeather(
        title,
        weather.map { it.toWeather() }
    )
}

