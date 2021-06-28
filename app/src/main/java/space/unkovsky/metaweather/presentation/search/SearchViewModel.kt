package space.unkovsky.metaweather.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.unkovsky.metaweather.default
import space.unkovsky.metaweather.presentation.Action
import space.unkovsky.metaweather.presentation.BaseViewModel
import space.unkovsky.metaweather.presentation.State
import space.unkovsky.metaweather.usecases.SearchLocationUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchLocationUseCase: SearchLocationUseCase
) : BaseViewModel() {

    override val stateLiveData = MutableLiveData<State>().default(SearchViewState.Empty)

    override fun dispatch(action: Action) {
        when (action) {
            is SearchAction.Search -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val list = searchLocationUseCase.searchLocation(action.query)

                    if (list.isEmpty()) {
                        updateState(SearchViewState.Empty)
                    } else {
                        updateState(SearchViewState.Locations(list))
                    }
                }
            }
        }
    }
}


