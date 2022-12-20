package com.gucodero.ui.binding.util

import com.gucodero.ui.binding.fragment.BindingFragment
import com.gucodero.ui.common.lifecycle.StatelessViewModel
import com.gucodero.ui.common.util.onEvent

fun <E, V: StatelessViewModel<E>> BindingFragment<*, V>.onEvent(block: suspend (E) -> Unit){
    onEvent(viewModel, block)
}