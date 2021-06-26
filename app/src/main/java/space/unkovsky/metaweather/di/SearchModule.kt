package space.unkovsky.metaweather.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import space.unkovsky.metaweather.usecases.SearchLocationRetrofitUseCase
import space.unkovsky.metaweather.usecases.SearchLocationUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class SearchModule {

    @Binds
    abstract fun bindSearchLocationUseCase(useCase: SearchLocationRetrofitUseCase): SearchLocationUseCase
}