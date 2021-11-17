package com.zinoview.tzipapp.presentation.core

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.zinoview.tzipapp.R
import com.zinoview.tzipapp.core.IpApp
import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import com.zinoview.tzipapp.databinding.ActivityMainBinding
import com.zinoview.tzipapp.presentation.IpViewModel
import com.zinoview.tzipapp.presentation.IpViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

fun Any?.log(message: String) {
    Timber.tag("zinoviewk").d(message)
}

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var ipVewModelFactory: IpViewModelFactory

    val ipViewModel: IpViewModel by viewModels {
        ipVewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inject()

        ipViewModel.observe(this) { uiStateScreenIp ->
            uiStateScreenIp.handleState()
        }

        ipViewModel.ip()
    }

    private fun Activity.inject() {
        val application = this.application
        if (application is IpApp) {
            application.appComponent.inject(this@MainActivity)
        }
    }
}