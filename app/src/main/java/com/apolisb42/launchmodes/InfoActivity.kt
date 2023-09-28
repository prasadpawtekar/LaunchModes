package com.apolisb42.launchmodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LaunchModes", "onDestroy: InfoActivity")
    }
}