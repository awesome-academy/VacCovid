package com.sun.vaccovid19.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.sun.vaccovid19.utils.InternetUtils

class ConnectInternetReceiver(
    private val netWorkListener: OnNetWorkChangeListener
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        netWorkListener.onNetWorkChange(InternetUtils.isNetworkConnected(context))
    }
}
