package com.gucodero.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.gucodero.ui.theme.ArchitectureAndroidTheme
import com.gucodero.ui.R

abstract class ScreenBottomSheetDialog(
    isCancelable: Boolean = true
): BottomSheetDialogFragment() {

    init {
        this.isCancelable = isCancelable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_AppBottomSheetDialog);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ArchitectureAndroidTheme {
                    Screen()
                }
            }
        }
    }

    @Composable
    abstract fun Screen()

}