package com.gucodero.ui.base

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.gucodero.ui.components.LoadingScreen
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

abstract class BaseActivity: AppCompatActivity() {

    private var onPermissionResult: (Boolean) -> Unit = {}

    private val requestPermissionsContract =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            onPermissionResult(it.count { result -> !result.value } == 0)
        }

    suspend fun requestPermission(permissions: List<String>): Boolean {
        return suspendCoroutine { cont ->
            onPermissionResult = {
                cont.resume(it)
            }
            requestPermissionsContract.launch(permissions.toTypedArray())
        }
    }

    private val loading: LoadingScreen by lazy {
        LoadingScreen()
    }

    fun showLoading() {
        loading.show()
    }

    fun hideLoading() {
        loading.hide()
    }

    fun isLoading() = loading.isAdded

    private fun LoadingScreen.show() {
        try {
            if (!isAdded) {
                show(supportFragmentManager, LOADING_TAG)
            }
        } catch (_: Exception) {
        }
    }

    private fun LoadingScreen.hide() {
        try {
            dismiss()
        } catch (ex: Exception) {
        }
    }

    companion object {
        private const val LOADING_TAG = "LOADING"
    }

}