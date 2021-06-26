package space.unkovsky.metaweather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LocationSearchDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    @SerializedName("woeid")
    val woeid: Integer,
    @SerializedName("latt_long")
    val latLong: LatLonDto
)

