package com.example.android.educacionit.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TimerService: Service() {

    override fun onCreate() {
        super.onCreate()
        Log.i("Timer service", "temporizador creado")
    }
    override fun onBind(p0: Intent?): IBinder? {

        Log.i("Timer service", "componente enlazado")
       return null

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread{
            Log.i("Timer service", "tarea iniciada")
            Thread.sleep(5000)
            Log.i("Timer service", "tarea finalizada")
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Timer service", "temporizador destruido")
    }
}