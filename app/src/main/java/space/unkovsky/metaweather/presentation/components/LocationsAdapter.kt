package space.unkovsky.metaweather.presentation.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.unkovsky.metaweather.data.local.Entity.Location
import space.unkovsky.metaweather.databinding.ItemCityBinding
import space.unkovsky.metaweather.markText

class LocationsAdapter(
    private val onItemClickListener: (woeid: Int) -> Unit
) : RecyclerView.Adapter<LocationsAdapter.LocationViewHolder>() {

    private var textToMark: String = ""
    private var locations: List<Location> = listOf()


    fun setData(locations: List<Location>, textToMark: String) {
        this.locations = locations
        this.textToMark = textToMark
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(locations[position], textToMark, onItemClickListener)
    }

    override fun getItemCount() = locations.size

    class LocationViewHolder(private val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(
            location: Location,
            textToMark: String,
            onItemClickListener: (woeid: Int) -> Unit
        ) {
            binding.textLocation.text = markText(location.title, textToMark)
            binding.root.setOnClickListener {
                onItemClickListener(location.woeid)
            }
        }
    }
}