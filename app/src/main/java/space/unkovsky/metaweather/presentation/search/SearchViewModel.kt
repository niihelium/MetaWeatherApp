package space.unkovsky.metaweather.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import space.unkovsky.metaweather.data.remote.MetaWeatherApiService
import space.unkovsky.metaweather.presentation.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
//    private val weatherApiService: MetaWeatherApiService
) : BaseViewModel() {

   override val stateLiveData: MutableLiveData<State> = MutableLiveData()

    override fun dispatch(action: Action) {
        when (action){

        }
    }
}

sealed class State{

}

sealed class Action