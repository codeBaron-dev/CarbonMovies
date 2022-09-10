package com.codebaron.domain.internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.MutableLiveData
import com.codebaron.domain.internet.handler.InternetConnectionHandler
import com.codebaron.domain.internet.model.InternetConfigObject

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 * @see InternetConfigViewModel
 * This function handles listening to network change state
 */
class InternetConnectivityConfig {

    companion object {
        lateinit var internetConnectivityConfig: InternetConnectivityConfig
    }

    fun networkInstance(): InternetConnectivityConfig {
        internetConnectivityConfig = InternetConnectivityConfig()
        return internetConnectivityConfig
    }

    fun internetConfig(context: Context): MutableLiveData<InternetConnectionHandler<InternetConfigObject>> {
        val internetConnectionHandler: MutableLiveData<InternetConnectionHandler<InternetConfigObject>> =
            MutableLiveData()

        val networkRequest: NetworkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                internetConnectionHandler.postValue(
                    InternetConnectionHandler.IsInternetAvailable(
                        true
                    )
                )
            }

            override fun onCapabilitiesChanged(
                network: Network,
                networkCapabilities: NetworkCapabilities
            ) {
                super.onCapabilitiesChanged(network, networkCapabilities)
                val unMetered =
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
                internetConnectionHandler.postValue(
                    InternetConnectionHandler.IsInternetConnectionTypeChanged(
                        true
                    )
                )
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                internetConnectionHandler.postValue(
                    InternetConnectionHandler.IsInternetConnectionLost(
                        true
                    )
                )
            }
        }

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, networkCallback)

        return internetConnectionHandler
    }
}