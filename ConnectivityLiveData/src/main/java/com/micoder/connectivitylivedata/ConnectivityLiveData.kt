package com.micoder.connectivitylivedata

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class ConnectivityLiveData(private val connectivityManager: ConnectivityManager) : LiveData<Boolean>() {

    private var active:Boolean = false
    private var onAvailable:Boolean = false
    private var lost:Boolean = false
    private var inactive:Boolean = false

    constructor(application: Application) : this(application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            onAvailable = true
            super.onAvailable(network)
            setValueInLiveData()
        }

        override fun onLost(network: Network) {
            lost = true
            super.onLost(network)
            setValueInLiveData()
        }
    }

    override fun onActive() {
        active = true
        super.onActive()
        val builder= NetworkRequest.Builder()
        connectivityManager.registerNetworkCallback(builder.build(),networkCallback)
        setValueInLiveData()
    }

    override fun onInactive() {
        inactive = true
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
        setValueInLiveData()
    }
    private fun setValueInLiveData(){
        if(active && onAvailable){
            postValue(true)
            setFalse()
        }
        if(active){
            postValue(false)
            setFalse()
        }
        if(onAvailable){
            postValue(true)
            setFalse()
        }
        if(lost){
            postValue(false)
            setFalse()
        }
    }

    private fun setFalse(){
        active = false
        onAvailable = false
        lost = false
        inactive = false
    }
}