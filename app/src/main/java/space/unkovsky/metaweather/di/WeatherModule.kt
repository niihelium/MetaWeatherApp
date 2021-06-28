package space.unkovsky.metaweather.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import space.unkovsky.metaweather.usecases.GetWeatherUseCase
import space.unkovsky.metaweather.usecases.GetWeatherUseCaseRetrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class WeatherModule {

    @Binds
    abstract fun bindGetWeatherUseCase(useCase: GetWeatherUseCaseRetrofit): GetWeatherUseCase
}