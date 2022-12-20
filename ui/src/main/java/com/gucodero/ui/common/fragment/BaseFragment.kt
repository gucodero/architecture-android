package com.gucodero.ui.common.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.gucodero.ui.R
import com.gucodero.ui.common.entities.BottomNavMode
import com.gucodero.ui.common.entities.ToolbarMode
import com.gucodero.ui.common.util.BackPressedCallback
import com.gucodero.ui.common.util.setBottomNavMode
import com.gucodero.ui.common.util.setToolbarMode

abstract class BaseFragment(
    private val fullScreen: Boolean = false,
    private val animation: Int? = null,
    isCancelable: Boolean = true
): DialogFragment() {

    init {
        this.isCancelable = isCancelable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(fullScreen){
            setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
        } else {
            setStyle(STYLE_NO_TITLE, R.style.Theme_AppDialog)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.let { dialog ->
            if(fullScreen){
                val width = ViewGroup.LayoutParams.MATCH_PARENT
                val height = ViewGroup.LayoutParams.MATCH_PARENT
                dialog.window?.setLayout(width, height)
            }
            animation?.let { animation ->
                dialog.window?.setWindowAnimations(animation)
            }
        }
    }

    open fun toolbarMode(): ToolbarMode = ToolbarMode.None

    open fun bottomNavMode(): BottomNavMode = BottomNavMode.None

    private fun initActivityScaffold(){
        requireActivity().apply {
            setToolbarMode(toolbarMode())
            setBottomNavMode(bottomNavMode())
        }
    }

    open fun onBackPressed(): BackPressedCallback? = null

    private val _backPressedAction by lazy {
        onBackPressed()
    }

    private val onBackPressedCallback: OnBackPressedCallback by lazy {
        val callback = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                onBackPressedCallback.isEnabled = false
                _backPressedAction?.invoke()
                onBackPressedCallback.isEnabled = true
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
        callback
    }

    private fun initBackPressed() {
        _backPressedAction?.let {
            onBackPressedCallback.isEnabled = true
        }
    }

    protected fun callOnBackPressed(){
        onBackPressed()?.invoke()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActivityScaffold()
        initBackPressed()
    }

    protected fun DialogFragment.show(tag: String? = null){
        try {
            val manager = this@BaseFragment.childFragmentManager
            if(!isAdded){
                this.show(manager, tag)
            }
        } catch (e: Exception){
            Log.e("DIALOG_EXCEPTION", "", e)
        }
    }

    fun NavDirections.navigate(){
        findNavController().navigate(this)
    }

}