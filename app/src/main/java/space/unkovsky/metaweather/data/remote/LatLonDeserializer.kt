package space.unkovsky.metaweather.data.remote

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import space.unkovsky.metaweather.data.remote.dto.LatLonDto
import java.lang.reflect.Type


class LatLonDeserializer : JsonDeserializer<LatLonDto> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): LatLonDto {
        val data = json.asJsonPrimitive.asString.split(",").map { it.toFloat() }.toTypedArray()
        return LatLonDto(data[0], data[1])
    }
}