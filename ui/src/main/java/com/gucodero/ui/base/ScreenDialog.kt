package com.gucodero.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.DialogFragment
import com.gucodero.ui.theme.ArchitectureAndroidTheme
import com.gucodero.ui.R

abstract class ScreenDialog(
    isCancelable: Boolean = true
): DialogFragment() {

    init {
        this.isCancelable = isCancelable
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_AppDialog);
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