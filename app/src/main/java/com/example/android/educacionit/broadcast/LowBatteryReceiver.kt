package com.example.android.educacionit.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.android.educacionit.extensions.toast

class LowBatteryReceiver:BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        p0?.toast("sin bateria capo!")
    }
}