package com.able.common.net.connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

/**
 * Create by 赵思琦 on 2022/3/10
 * email zsqandzyr@gmail.com
 */
class ConnectionManage constructor(context: Context) {
    val connectivityManager = context.getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager
    fun registerNetworkStates(){
        val NetTag = "网络状态"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(object :
                ConnectivityManager.NetworkCallback() {
                //网络可用时
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    Log.i(NetTag, "网络可用时");
                }

                //网络访问被阻止
                override fun onBlockedStatusChanged(network: Network, blocked: Boolean) {
                    super.onBlockedStatusChanged(network, blocked)
                    Log.i(NetTag, "网络访问被阻止");
                }

                //发生变化
                override fun onLinkPropertiesChanged(
                    network: Network,
                    linkProperties: LinkProperties
                ) {
                    super.onLinkPropertiesChanged(network, linkProperties)
                    Log.i(NetTag, "发生变化");
                }

                //即将丢失
                override fun onLosing(network: Network, maxMsToLive: Int) {
                    super.onLosing(network, maxMsToLive)
                    Log.i(NetTag, "即将丢失");
                }

                //断开
                override fun onLost(network: Network) {
                    super.onLost(network)
                    Log.i(NetTag, "断开");
                }

                //超时
                override fun onUnavailable() {
                    super.onUnavailable()
                    Log.i(NetTag, "超时");
                }
            })
        }
//        ()
    }

}