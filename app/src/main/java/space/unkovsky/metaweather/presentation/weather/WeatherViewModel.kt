package space.unkovsky.metaweather.presentation.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.unkovsky.metaweather.default
import space.unkovsky.metaweather.presentation.Action
import space.unkovsky.metaweather.presentation.BaseViewModel
import space.unkovsky.metaweather.presentation.State
import space.unkovsky.metaweather.usecases.GetWeatherUseCase
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
) : BaseViewModel() {
    override val stateLiveData = MutableLiveData<State>().default(WeatherViewState.Empty)


    override fun dispatch(action: Action) {
        when (action) {
            is WeatherAction.WeatherRequest -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val weather = getWeatherUseCase.getWeather(action.woeid)

                    if (weather.title.isBlank() && weather.weatherStateName.isBlank()) {
                        updateState(WeatherViewState.Weather(weather))
                    } else {
                        updateState(WeatherViewState.Weather(weather))
                    }
                }
            }

        }
    }
}

