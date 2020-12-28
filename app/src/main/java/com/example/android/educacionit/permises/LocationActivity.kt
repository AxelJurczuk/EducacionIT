package com.example.android.educacionit.permises

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.educacionit.R
import com.example.android.educacionit.databinding.ActivityLocationBinding

class LocationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}