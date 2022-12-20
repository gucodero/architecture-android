package com.gucodero.ui.compose.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import com.gucodero.ui.common.fragment.BaseBottomSheet
import com.gucodero.ui.compose.theme.ArchitectureAndroidTheme

abstract class ScreenBottomSheetDialog(
    isCancelable: Boolean = true
): BaseBottomSheet(
    isCancelable = isCancelable
) {

    open fun onInit() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onInit()
        return ComposeView(requireContext()).apply {
            setContent {
                ArchitectureAndroidTheme {
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                    ) {
                        Screen()
                    }
                }
            }
        }
    }

    @Composable
    abstract fun Screen()

}