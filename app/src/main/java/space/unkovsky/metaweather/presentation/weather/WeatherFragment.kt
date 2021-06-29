package space.unkovsky.metaweather.presentation.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import space.unkovsky.metaweather.R
import space.unkovsky.metaweather.databinding.FragmentWeatherBinding
import space.unkovsky.metaweather.presentation.BaseFragment
import space.unkovsky.metaweather.presentation.State

@AndroidEntryPoint
class WeatherFragment : BaseFragment(R.layout.fragment_weather) {

    private val args: WeatherFragmentArgs by navArgs()

    override val binding
        get() = super.binding as FragmentWeatherBinding


    override val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.dispatch(WeatherAction.WeatherRequest(args.woeid))
    }

    override fun render(state: State) {
        when (state) {
            is WeatherViewState.Empty -> {
                with(binding) {
                    textLocation.visibility = View.GONE
                    textTemperature.visibility = View.GONE
                }
            }
            is WeatherViewState.Weather -> {
                with(binding) {

                    textLocation.apply {
                        visibility = View.VISIBLE
                        text = state.locationWeather.title
                    }
//                    imageWeatherIcon.
                    textTemperature.apply {
                        visibility = View.VISIBLE
                        text =
                            "${state.locationWeather.minTemp}..${state.locationWeather.maxTemp}"
                    }
                }
            }
        }
    }
}

