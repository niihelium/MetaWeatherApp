package space.unkovsky.metaweather.presentation.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import space.unkovsky.metaweather.Constants
import space.unkovsky.metaweather.data.local.Entity.Weather
import space.unkovsky.metaweather.databinding.ItemWeatherBinding

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var weather: List<Weather> = listOf()


    fun setData(weather: List<Weather>) {
        this.weather = weather
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weather[position])
    }

    override fun getItemCount() = weather.size

    class WeatherViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            weather: Weather,
        ) {
            with(binding) {
                date.text = weather.date
                Glide.with(binding.root)
                    .load(Constants.BASE_URL + Constants.IMGURL + weather.weatherStateAbbr + Constants.PNG)
                    .into(weatherIcon)
                temperature.text = "${weather.minTemp}/${weather.maxTemp}"

            }
        }
    }
}