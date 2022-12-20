package com.gucodero.ui.common.activity.base

interface LoadingActivity {
    fun showLoading()
    fun hideLoading()
    fun isLoading(): Boolean
}