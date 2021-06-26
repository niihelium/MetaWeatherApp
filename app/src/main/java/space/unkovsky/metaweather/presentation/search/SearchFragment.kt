package space.unkovsky.metaweather.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import space.unkovsky.metaweather.R
import space.unkovsky.metaweather.data.local.Location
import space.unkovsky.metaweather.databinding.FragmentSearchBinding
import space.unkovsky.metaweather.presentation.BaseFragment
import space.unkovsky.metaweather.presentation.State
import space.unkovsky.metaweather.presentation.components.LocationsAdapter

@AndroidEntryPoint
class SearchFragment : BaseFragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override val viewModel: SearchViewModel by viewModels()

    val locations = mutableListOf<Location>()
    val locationsAdapter = LocationsAdapter(locations) {
        val action = SearchFragmentDirections.actionSearchFragmentToWeatherFragment(it)
        findNavController().navigate(action)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(layoutInflater)
        with(binding.recyclerCities) {
            adapter = locationsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        binding.btnSearch.setOnClickListener {
            viewModel.dispatch(
                SearchAction.Search(
                    binding.editSearch.text.toString()
                )
            )
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun render(state: State) {
        if (state !is SearchViewState) return
        when (state) {
            is SearchViewState.Empty -> {
                with(binding) {
                    textNoLocations.visibility = View.VISIBLE
                    recyclerCities.visibility = View.GONE
                }
            }
            is SearchViewState.Locations -> {
                locations.clear()
                locations.addAll(state.locations)
                with(binding) {
                    textNoLocations.visibility = View.GONE
                    recyclerCities.visibility = View.VISIBLE
                    locationsAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}