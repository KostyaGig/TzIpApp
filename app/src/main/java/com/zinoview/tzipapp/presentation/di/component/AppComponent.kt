package com.zinoview.tzipapp.presentation.di.component

import com.zinoview.tzipapp.presentation.core.MainActivity
import com.zinoview.tzipapp.presentation.di.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}