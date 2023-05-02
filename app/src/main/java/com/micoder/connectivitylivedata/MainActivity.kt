package com.micoder.connectivitylivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var connectivityLiveData: ConnectivityLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkConnection()

    }

    private fun checkConnection() {

        connectivityLiveData = ConnectivityLiveData(application)
        connectivityLiveData.observe(this) { isAvailable ->
            when (isAvailable) {
                true -> Toast.makeText(this@MainActivity, "True", Toast.LENGTH_LONG).show()
                false -> Toast.makeText(this@MainActivity, "False", Toast.LENGTH_LONG).show()
            }
        }

    }

}