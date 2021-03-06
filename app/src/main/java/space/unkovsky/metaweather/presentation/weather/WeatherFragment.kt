package space.unkovsky.metaweather.presentation.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import arrow.core.tail
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import space.unkovsky.metaweather.Constants
import space.unkovsky.metaweather.R
import space.unkovsky.metaweather.databinding.FragmentWeatherBinding
import space.unkovsky.metaweather.presentation.BaseFragment
import space.unkovsky.metaweather.presentation.State
import space.unkovsky.metaweather.presentation.components.WeatherAdapter


@AndroidEntryPoint
class WeatherFragment : BaseFragment(R.layout.fragment_weather) {

    private val args: WeatherFragmentArgs by navArgs()

    override val binding
        get() = super.binding as FragmentWeatherBinding


    override val viewModel: WeatherViewModel by viewModels()

    private val weatherAdapter = WeatherAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(layoutInflater)
        with(binding.weatherDays) {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(context)
        }
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
                    (state.locationWeather.weather[0]).let { todayWeather ->
                        textLocation.apply {
                            visibility = View.VISIBLE
                            text = state.locationWeather.title
                        }
                        Glide.with(binding.root)
                            .load(Constants.BASE_URL + Constants.IMGURL + todayWeather.weatherStateAbbr + Constants.PNG)
                            .into(imageWeatherIcon)
                        textTemperature.apply {
                            visibility = View.VISIBLE
                            text =
                                "${todayWeather.minTemp}..${todayWeather.maxTemp}"
                        }
                    }
                }
                weatherAdapter.setData(state.locationWeather.weather.tail())
            }
        }
    }
}

