package com.gucodero.ui.compose.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.gucodero.ui.common.util.getViewModel
import com.gucodero.ui.common.util.initLoading
import org.koin.core.parameter.ParametersHolder
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

abstract class ScreenFragment<V: ViewModel>(
    private val clazz: KClass<V>,
    private val viewModelStore: Int? = null,
    fullScreen: Boolean = false,
    animation: Int? = null,
    isCancelable: Boolean = true
) : ScreenDialog(
    fullScreen = fullScreen,
    animation = animation,
    isCancelable = isCancelable
) {

    open fun getParameters(): ParametersHolder {
        return parametersOf()
    }

    val viewModel: V by lazy {
        getViewModel(
            clazz = clazz,
            parameters = ::getParameters,
            ownerProducer = {
                viewModelStore?.let(findNavController()::getViewModelStoreOwner) ?: this
            }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLoading(viewModel)
    }

}