package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName
import space.unkovsky.metaweather.data.local.Entity.LocationWeather
import space.unkovsky.metaweather.toTemp

data class LocationDto(
    @SerializedName("consolidated_weather")
    val weather: List<WeatherDto>,
    @SerializedName("title")
    val title: String
)

fun LocationDto.toLocationWeather(): LocationWeather {
    val currentWeather: WeatherDto = weather[0]
    return LocationWeather(
        currentWeather.date,
        currentWeather.weatherStateName,
        currentWeather.weatherStateAbbr,
        currentWeather.minTemp.toTemp(),
        currentWeather.maxTemp.toTemp(),
        title
    )
}

