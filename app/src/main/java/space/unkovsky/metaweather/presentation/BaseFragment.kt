package space.unkovsky.metaweather.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {
    abstract val viewModel: BaseViewModel

    protected var _binding: ViewBinding? = null
    open val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.stateLiveData.observe(this, { render(it) })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun render(state: State)
}