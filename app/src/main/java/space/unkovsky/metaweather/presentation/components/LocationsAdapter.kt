package space.unkovsky.metaweather.presentation.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.unkovsky.metaweather.data.local.Location
import space.unkovsky.metaweather.databinding.ItemCityBinding

class LocationsAdapter(private val cities: List<Location>) :
    RecyclerView.Adapter<LocationsAdapter.LocationViewHolder>() {
    class LocationViewHolder(private val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(location: Location) {
            binding.textLocation.text = location.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    override fun getItemCount() = cities.size
}