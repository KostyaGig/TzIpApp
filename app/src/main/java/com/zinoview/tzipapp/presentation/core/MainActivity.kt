package com.zinoview.tzipapp.presentation.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zinoview.tzipapp.databinding.ActivityMainBinding
import timber.log.Timber

fun Any?.log(message: String) {
    Timber.tag("zinoviewk").d(message)
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}