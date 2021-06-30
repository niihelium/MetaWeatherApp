package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.Entity.Location
import space.unkovsky.metaweather.data.remote.MetaWeatherApi
import space.unkovsky.metaweather.data.remote.dto.toLocation
import space.unkovsky.metaweather.getApiResult
import javax.inject.Inject

class SearchLocationUseCaseRetrofit @Inject constructor(
    private val api: MetaWeatherApi
) : SearchLocationUseCase {
    override suspend operator fun invoke(query: String): Result<List<Location>> {
        return getApiResult { api.locationSearch(query) }.map { it.map { it.toLocation() } }
    }
}