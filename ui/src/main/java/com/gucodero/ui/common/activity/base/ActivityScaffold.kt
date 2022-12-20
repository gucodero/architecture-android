package com.gucodero.ui.common.activity.base

import com.gucodero.ui.common.entities.BottomNavMode
import com.gucodero.ui.common.entities.ToolbarMode

interface ActivityScaffold {
    fun setToolbarMode(toolbarMode: ToolbarMode)
    fun setBottomNavMode(bottomNavMode: BottomNavMode)
}