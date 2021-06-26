package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("consolidated_weather")
    val weather: List<WeatherDto>,
    @SerializedName("title")
    val title: String
)