package space.unkovsky.metaweather.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import space.unkovsky.metaweather.R
import space.unkovsky.metaweather.data.local.Location
import space.unkovsky.metaweather.databinding.FragmentSearchBinding
import space.unkovsky.metaweather.presentation.BaseFragment
import space.unkovsky.metaweather.presentation.components.LocationsAdapter

class SearchFragment : BaseFragment(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by viewModels()

    val locations = mutableListOf(
        Location("A", 123),
        Location("A", 123),
        Location("A", 123),
        Location("A", 123),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(layoutInflater)
        val locationsAdapter = LocationsAdapter(locations)
        with(binding.recyclerCities) {
            adapter = locationsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        binding.btnSearch.setOnClickListener {

        }
        return binding.root
    }


//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }


    override fun render(it: State) {
    }
}