package space.unkovsky.metaweather.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import space.unkovsky.metaweather.data.remote.dto.toLocation
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

    private var requestJob: Job? = null

    override fun dispatch(action: Action) {
        when (action) {
            is SearchAction.Search -> {
                requestJob?.cancel()
                requestJob = viewModelScope.launch(Dispatchers.IO) {
                    if (isActive)
                        searchLocationUseCase(action.query).fold({
                            updateState(SearchViewState.Locations(it))
                        }, {
                            updateState(SearchViewState.Empty)
                        })
                }
            }
        }
    }
}


