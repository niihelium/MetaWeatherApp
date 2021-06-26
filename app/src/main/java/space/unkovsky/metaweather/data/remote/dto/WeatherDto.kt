package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName

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