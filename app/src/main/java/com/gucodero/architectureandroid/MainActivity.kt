package com.gucodero.architectureandroid

import android.os.Bundle
import com.gucodero.ui.base.BaseActivity

class MainActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}