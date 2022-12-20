package com.gucodero.ui.common.util

import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.gucodero.ui.common.activity.base.LoadingActivity
import com.gucodero.ui.common.lifecycle.base.WithLoadingEvent
import com.gucodero.ui.common.lifecycle.base.WithUiEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.getKoinScope
import org.koin.androidx.viewmodel.resolveViewModel
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.parameter.ParametersHolder
import org.koin.core.qualifier.Qualifier
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.KClass

typealias BackPressedCallback = (() -> Unit)

internal fun Fragment.requireLoadingActivity(): LoadingActivity? {
    val result = requireActivity()
    return if (result is LoadingActivity) {
        result
    } else {
        null
    }
}

fun Fragment.showLoading() {
    requireLoadingActivity()?.showLoading()
}

fun Fragment.showLoading(timeMillis: Long) {
    lifecycleScope.launch {
        requireLoadingActivity()?.showLoading()
        delay(timeMillis)
        hideLoading()
    }
}

fun Fragment.hideLoading() {
    requireLoadingActivity()?.hideLoading()
}

fun Fragment.isLoading(): Boolean = requireLoadingActivity()?.isLoading() ?: false

fun Fragment.navigate(directions: NavDirections) {
    lifecycleScope.launchWhenResumed {
        findNavController().navigate(directions)
    }
}

fun Fragment.navigate(@IdRes resId: Int) {
    lifecycleScope.launchWhenResumed {
        findNavController().navigate(resId)
    }
}

fun Fragment.popBackStack() {
    findNavController().popBackStack()
}

fun Fragment.popBackStack(@IdRes destinationId: Int, inclusive: Boolean = false) {
    findNavController().popBackStack(destinationId, inclusive)
}

fun Fragment.launch(context: CoroutineContext = EmptyCoroutineContext, block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch(
        block = block,
        context = context
    )
}

fun <UiEvent> Fragment.onEvent(withUiEvent: WithUiEvent<UiEvent>, block: suspend (UiEvent) -> Unit){
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            withUiEvent.setOnEvent(block)
        }
    }
}

fun Fragment.initLoading(viewModel: ViewModel){
    if(viewModel is WithLoadingEvent){
        lifecycleScope.launch {
            try {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.onLoading {
                        if(it){
                            showLoading()
                        } else {
                            hideLoading()
                        }
                    }
                }
                awaitCancellation()
            } finally {
                if(!viewModel.loading){
                    viewModel.loading = false
                    hideLoading()
                }
            }
        }
    }
}

@OptIn(KoinInternalApi::class)
@MainThread
fun <T : ViewModel> Fragment.getViewModel(
    clazz: KClass<T>,
    qualifier: Qualifier? = null,
    ownerProducer: () -> ViewModelStoreOwner = { this },
    extrasProducer: (() -> CreationExtras)? = null,
    parameters: (() -> ParametersHolder)? = null,
): T {
    return resolveViewModel(
        clazz,
        ownerProducer().viewModelStore,
        extras = extrasProducer?.invoke() ?: this.defaultViewModelCreationExtras,
        qualifier = qualifier,
        parameters = parameters,
        scope = getKoinScope()
    )
}