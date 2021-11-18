package com.zinoview.tzipapp.presentation.di.component

import com.zinoview.tzipapp.presentation.core.MainActivity
import com.zinoview.tzipapp.presentation.di.module.AppModule
import com.zinoview.tzipapp.presentation.fragment.HistoryRequestIpFragment
import com.zinoview.tzipapp.presentation.fragment.IpFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(ipFragment: IpFragment)
    fun inject(historyRequestIpFragment: HistoryRequestIpFragment)
}