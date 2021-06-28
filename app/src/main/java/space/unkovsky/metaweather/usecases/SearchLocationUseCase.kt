package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.Location

interface SearchLocationUseCase {
    suspend operator fun invoke(query: String): List<Location>
}