package space.unkovsky.metaweather.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import space.unkovsky.metaweather.presentation.search.State

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.stateLiveData.observe(this, { render(it) })
    }

    abstract fun render(it: State)
}