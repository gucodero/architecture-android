package com.gucodero.ui.common.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.gucodero.ui.R
import com.gucodero.ui.common.entities.BottomNavMode
import com.gucodero.ui.common.entities.ToolbarMode
import com.gucodero.ui.common.util.setBottomNavMode
import com.gucodero.ui.common.util.setToolbarMode

abstract class BaseBottomSheet(
    isCancelable: Boolean = true
): BottomSheetDialogFragment() {

    init {
        this.isCancelable = isCancelable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_AppBottomSheetDialog);
    }

    open fun toolbarMode(): ToolbarMode = ToolbarMode.None

    open fun bottomNavMode(): BottomNavMode = BottomNavMode.None

    private fun initActivityScaffold(){
        requireActivity().apply {
            setToolbarMode(toolbarMode())
            setBottomNavMode(bottomNavMode())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActivityScaffold()
    }

    protected fun DialogFragment.show(){
        if(!isAdded){
            this.show(this@BaseBottomSheet.childFragmentManager, null)
        }
    }

    fun NavDirections.navigate(){
        findNavController().navigate(this)
    }

}