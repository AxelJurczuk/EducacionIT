package com.example.android.educacionit

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.educacionit.broadcast.LowBatteryReceiver

abstract class BaseActivity : AppCompatActivity(){
    private val intentFilter= IntentFilter()
    private val lowBatteryReceiver= LowBatteryReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_low_battery)

        intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
    }


    override fun onStart() {
        super.onStart()
        registerReceiver(lowBatteryReceiver,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(lowBatteryReceiver)
    }
}