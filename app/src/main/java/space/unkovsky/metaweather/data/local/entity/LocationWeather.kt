package space.unkovsky.metaweather.data.local.entity

data class LocationWeather(
    val title: String = "",
    val weather: List<Weather> = listOf()
)

data class Weather(
    val date: String = "",
    val weatherStateName: String = "",
    val weatherStateAbbr: String = "",
    val minTemp: String = "",
    val maxTemp: String = "",
)