package com.gucodero.ui.common.activity

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.gucodero.ui.common.activity.base.LoadingActivity
import com.gucodero.ui.common.component.LoadingScreen
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

abstract class BaseActivity: AppCompatActivity(), LoadingActivity {

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

    override fun showLoading() {
        loading.show()
    }

    override fun hideLoading() {
        loading.hide()
    }

    override fun isLoading() = loading.isAdded

    private fun LoadingScreen.show() {
        try {
            if (!isAdded) {
                show(supportFragmentManager, LOADING_TAG)
            }
        } catch (_: Exception) {}
    }

    private fun LoadingScreen.hide() {
        try {
            dismiss()
        } catch (_: Exception) { }
    }

    companion object {
        private const val LOADING_TAG = "LOADING"
    }

}