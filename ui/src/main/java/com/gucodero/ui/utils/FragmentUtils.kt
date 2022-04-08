package com.gucodero.ui.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.gucodero.ui.base.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal fun Fragment.requireBaseActivity(): BaseActivity? {
    val result = requireActivity()
    return if (result is BaseActivity) {
        result
    } else {
        null
    }
}

fun Fragment.showLoading() {
    requireBaseActivity()?.showLoading()
}

fun Fragment.showLoading(timeMillis: Long) {
    lifecycleScope.launch {
        requireBaseActivity()?.showLoading()
        delay(timeMillis)
        hideLoading()
    }
}

fun Fragment.hideLoading() {
    requireBaseActivity()?.hideLoading()
}

fun Fragment.isLoading(): Boolean = requireBaseActivity()?.isLoading() ?: false

fun Fragment.navigate(directions: NavDirections) {
    lifecycleScope.launchWhenResumed {
        findNavController().navigate(directions)
    }
}

fun Fragment.popBackStack() {
    findNavController().popBackStack()
}

fun Fragment.popBackStack(@IdRes destinationId: Int, inclusive: Boolean = false) {
    findNavController().popBackStack(destinationId, inclusive)
}