package com.gucodero.ui.common.util

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gucodero.ui.common.activity.base.ActivityScaffold
import com.gucodero.ui.common.entities.BottomNavMode
import com.gucodero.ui.common.entities.ToolbarMode
import com.gucodero.ui.common.lifecycle.base.WithUiEvent
import kotlinx.coroutines.launch

fun Activity.setToolbarMode(toolbarMode: ToolbarMode){
    if(this is ActivityScaffold){
        this.setToolbarMode(toolbarMode)
    }
}

fun Activity.setBottomNavMode(bottomNavMode: BottomNavMode){
    if(this is ActivityScaffold){
        this.setBottomNavMode(bottomNavMode)
    }
}

fun <UiEvent> AppCompatActivity.onEvent(viewModel: WithUiEvent<UiEvent>, block: suspend (UiEvent) -> Unit) {
    lifecycleScope.launch {
        viewModel.setOnEvent(block)
    }
}