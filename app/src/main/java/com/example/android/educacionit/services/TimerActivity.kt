package com.example.android.educacionit.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.educacionit.R
import com.example.android.educacionit.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTimerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)


    }
}