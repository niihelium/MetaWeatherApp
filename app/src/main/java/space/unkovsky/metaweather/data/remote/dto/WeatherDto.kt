package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName
import space.unkovsky.metaweather.data.local.entity.Weather
import space.unkovsky.metaweather.toTemp

data class WeatherDto(
    @SerializedName("applicable_date")
    val date: String,
    @SerializedName("weather_state_name")
    val weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("min_temp")
    val minTemp: Float,
    @SerializedName("max_temp")
    val maxTemp: Float
)

fun WeatherDto.toWeather(): Weather{
    return Weather(
        date,
        weatherStateName,
        weatherStateAbbr,
        minTemp.toTemp(),
        maxTemp.toTemp(),
    )
}