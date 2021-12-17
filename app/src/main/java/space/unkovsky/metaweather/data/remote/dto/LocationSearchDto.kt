package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName
import space.unkovsky.metaweather.data.local.entity.Location

data class LocationSearchDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    @SerializedName("woeid")
    val woeid: Int,
    @SerializedName("latt_long")
    val latLong: LatLonDto
)

fun LocationSearchDto.toLocation() = Location(title, woeid)

