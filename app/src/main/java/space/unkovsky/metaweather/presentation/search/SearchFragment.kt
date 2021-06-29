package space.unkovsky.metaweather.presentation.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import space.unkovsky.metaweather.R
import space.unkovsky.metaweather.databinding.FragmentSearchBinding
import space.unkovsky.metaweather.presentation.BaseFragment
import space.unkovsky.metaweather.presentation.State
import space.unkovsky.metaweather.presentation.components.LocationsAdapter

@AndroidEntryPoint
class SearchFragment : BaseFragment(R.layout.fragment_search) {

    override val binding
        get() = super.binding as FragmentSearchBinding

    override val viewModel: SearchViewModel by viewModels()

    private val locationsAdapter = LocationsAdapter {
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

        binding.editSearch.addTextChangedListener(
            object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {
                    viewModel.dispatch(
                        SearchAction.Search(s.toString())
                    )
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                }
            }
        )
        return binding.root
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
                with(binding) {
                    textNoLocations.visibility = View.GONE
                    recyclerCities.visibility = View.VISIBLE
                    locationsAdapter.setData(state.locations, editSearch.text.toString())
                }
            }
        }
    }
}