package com.gucodero.ui.binding.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.gucodero.ui.common.fragment.BaseFragment

abstract class BindingDialog<B: ViewDataBinding>(
    fullScreen: Boolean = false,
    animation: Int? = null,
    isCancelable: Boolean = true
): BaseFragment(
    fullScreen = fullScreen,
    animation = animation,
    isCancelable = isCancelable
) {

    protected lateinit var binding: B

    abstract fun onInflate(inflater: LayoutInflater): B

    open fun onInit() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = onInflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        onInit()
        return binding.root
    }

}