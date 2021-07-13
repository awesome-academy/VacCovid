@file:Suppress("DEPRECATION")

package com.example.vaccovid19.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vaccovid19.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(MainActivity.getIntent(this))
        finish()
    }
}
