@file:Suppress("DEPRECATION")

package com.sun.vaccovid19.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.vaccovid19.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(com.sun.vaccovid19.MainActivity.getIntent(this))
        finish()
    }
}
