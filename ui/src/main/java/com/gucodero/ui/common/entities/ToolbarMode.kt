package com.gucodero.ui.common.entities

import androidx.annotation.StringRes

sealed class ToolbarMode {
    data class Visible(
        @StringRes
        val titleId: Int,
        val allowBack: Boolean = false
    ): ToolbarMode()
    object Hide: ToolbarMode()
    object None: ToolbarMode()
}