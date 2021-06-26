package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.Location

interface SearchLocationUseCase {
    suspend fun searchLocation(query: String): List<Location>
}