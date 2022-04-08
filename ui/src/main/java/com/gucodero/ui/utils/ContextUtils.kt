package com.gucodero.ui.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.gucodero.ui.base.BaseActivity

suspend fun Context.requestPermissions(permissions: List<String>): Boolean {
    return if(this is BaseActivity){
        this.requestPermission(permissions)
    } else {
        false
    }
}

fun Context.isPermissionNecessary(permissions: List<String>): List<String>? {
    return permissions.filter {
        ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_DENIED
    }.ifEmpty {
        null
    }
}