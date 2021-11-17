package com.zinoview.tzipapp.core

import android.app.Application
import com.zinoview.tzipapp.BuildConfig
import com.zinoview.tzipapp.presentation.di.component.AppComponent
import com.zinoview.tzipapp.presentation.di.component.DaggerAppComponent
import com.zinoview.tzipapp.presentation.di.module.AppModule
import timber.log.Timber

class IpApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}