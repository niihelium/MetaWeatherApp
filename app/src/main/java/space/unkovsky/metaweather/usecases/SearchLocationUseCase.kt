package space.unkovsky.metaweather.usecases

import space.unkovsky.metaweather.data.local.Entity.Location

interface SearchLocationUseCase {
    suspend operator fun invoke(query: String): Result<List<Location>>
}