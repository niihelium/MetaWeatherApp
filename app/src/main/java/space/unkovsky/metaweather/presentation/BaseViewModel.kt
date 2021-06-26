package space.unkovsky.metaweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    abstract val stateLiveData: MutableLiveData<State>

    abstract fun dispatch(action: Action)

    fun updateState(state: State) {
        viewModelScope.launch(Dispatchers.Main) {
            stateLiveData.value = state
        }
    }
}

interface State

interface Action