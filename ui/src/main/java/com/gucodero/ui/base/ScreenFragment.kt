package com.gucodero.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.gucodero.ui.theme.ArchitectureAndroidTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.ParametersHolder
import org.koin.core.parameter.parametersOf
import kotlin.reflect.KClass

abstract class ScreenFragment<V : ViewModel>(
    private val clazz: KClass<V>,
    private val viewModelStore: Int? = null
) : DialogFragment() {

    protected val viewModel: V by lazy {
        if (viewModelStore != null) {
            findNavController().getViewModelStoreOwner(viewModelStore)
                .getViewModel(clazz = clazz, parameters = ::getParameters)
        } else {
            getViewModel(clazz = clazz, parameters = ::getParameters)
        }
    }

    open fun getParameters(): ParametersHolder {
        return parametersOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onInit()
        viewModel
        return ComposeView(requireContext()).apply {
            setContent {
                ArchitectureAndroidTheme {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                    ) {
                        Screen()
                    }
                }
            }
        }
    }

    open fun onInit() {}

    @Composable
    abstract fun Screen()

    protected fun DialogFragment.show(){
        if(!isAdded){
            this.show(this@ScreenFragment.childFragmentManager, null)
        }
    }

}