package com.zinoview.tzipapp.presentation.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.zinoview.tzipapp.core.IpApp
import com.zinoview.tzipapp.presentation.fragment.HistoryRequestIpFragment
import com.zinoview.tzipapp.presentation.fragment.IpFragment
import java.lang.IllegalArgumentException

abstract class BaseFragment(@LayoutRes id: Int) : Fragment(id) {


    protected fun inject(fragment: BaseFragment) {
        val application = (requireActivity().application)
        if (application is IpApp) {
            when (fragment) {
                is IpFragment -> application.appComponent.inject(fragment)
                is HistoryRequestIpFragment -> application.appComponent.inject(fragment)
                else -> throw IllegalArgumentException("Base fragment inject() not found arg ${fragment.javaClass}")
            }
        }
    }
}