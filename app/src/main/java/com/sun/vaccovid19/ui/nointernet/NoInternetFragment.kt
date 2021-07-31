package com.sun.vaccovid19.ui.nointernet

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.provider.Settings
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.sun.vaccovid19.MainActivity
import com.sun.vaccovid19.R
import com.sun.vaccovid19.base.BaseFragment
import com.sun.vaccovid19.broadcast.ConnectInternetReceiver
import com.sun.vaccovid19.broadcast.OnNetWorkChangeListener
import com.sun.vaccovid19.databinding.FragmentNoInternetLayoutBinding

class NoInternetFragment :
    BaseFragment<FragmentNoInternetLayoutBinding>(FragmentNoInternetLayoutBinding::inflate),
    OnClickListenerNoInternetFr,
    OnNetWorkChangeListener {

    private val receiver = ConnectInternetReceiver(this)

    override fun initData() {
        bindData()
        context?.registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onClickCancel() {
        activity?.finish()
    }

    override fun onClickConnect() {
        startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
    }

    private fun bindData() {
        binding.apply {
            clickListener = this@NoInternetFragment
        }
    }

    override fun onNetWorkChange(isConnected: Boolean) {
        if (isConnected) {
            findNavController().navigate(
                R.id.homeFragment, null, NavOptions.Builder()
                    .setPopUpTo(R.id.homeFragment, true)
                    .build()
            )
            (activity as MainActivity).binding.bottomNav.selectedItemId = R.id.homeFragment
        }
    }

    override fun onStop() {
        context?.unregisterReceiver(receiver)
        super.onStop()
    }
}
