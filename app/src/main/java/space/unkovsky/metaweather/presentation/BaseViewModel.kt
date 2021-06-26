package space.unkovsky.metaweather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.unkovsky.metaweather.presentation.search.Action
import space.unkovsky.metaweather.presentation.search.State

abstract class BaseViewModel : ViewModel() {
    abstract val stateLiveData: MutableLiveData<State>

    abstract fun dispatch(action: Action)
}