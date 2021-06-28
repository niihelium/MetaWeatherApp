package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.Location
import space.unkovsky.metaweather.data.remote.MetaWeatherApi
import space.unkovsky.metaweather.data.remote.dto.toLocation
import javax.inject.Inject

class SearchLocationUseCaseRetrofit @Inject constructor(
    private val api: MetaWeatherApi
) : SearchLocationUseCase {
    override suspend operator fun invoke(query: String): List<Location> {
        val response = api.locationSearch(query)
        return if (response.isSuccessful) {
            response.body()?.map { it.toLocation() } ?: listOf()
        } else {
            listOf()
        }

    }
}