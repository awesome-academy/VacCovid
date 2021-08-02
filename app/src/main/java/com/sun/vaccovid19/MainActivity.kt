package com.sun.vaccovid19

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sun.vaccovid19.databinding.ActivityMainBinding
import com.sun.vaccovid19.utils.AppConstant.IS_FROM_LOCAL
import com.sun.vaccovid19.utils.InternetUtils

class MainActivity : AppCompatActivity() {

    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        val navController = navHost.navController
        val graph = navController.navInflater.inflate(R.navigation.nav_graph)

        graph.setStartDestination(
            if (InternetUtils.isNetworkConnected(this)) R.id.homeFragment else R.id.noInternetFragment
        )
        navController.graph = graph
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.vaccineFragment) {
                val argument = NavArgument.Builder().setDefaultValue(false).build()
                destination.addArgument(IS_FROM_LOCAL, argument)
            }
        }
        binding.bottomNav.apply {
            setOnNavigationItemSelectedListener {
                switchFragment(it.itemId, navController)
                true
            }
        }
    }

    private fun switchFragment(id: Int, navController: NavController) {
        navController.apply {
            if (!InternetUtils.isNetworkConnected(this@MainActivity)) {
                navigate(R.id.noInternetFragment)
            } else {
                navigateUp()
                navigate(id)
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
