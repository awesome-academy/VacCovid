package com.sun.vaccovid19

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgument
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.sun.vaccovid19.databinding.ActivityMainBinding
import com.sun.vaccovid19.utils.AppConstant.IS_FROM_LOCAL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        val navController = navHost.navController
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.vaccineFragment) {
                val argument = NavArgument.Builder().setDefaultValue(false).build()
                destination.addArgument(IS_FROM_LOCAL, argument)
            }
        }
        binding.bottomNav.setupWithNavController(navController)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
