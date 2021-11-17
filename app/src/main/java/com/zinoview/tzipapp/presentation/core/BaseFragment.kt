package com.zinoview.tzipapp.presentation.core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.zinoview.tzipapp.core.IpApp
import com.zinoview.tzipapp.presentation.fragment.IpFragment

abstract class BaseFragment(@LayoutRes id: Int) : Fragment(id) {


    protected fun inject(fragment: BaseFragment) {
        val application = (requireActivity().application)
        if (application is IpApp) {
            if (fragment is IpFragment) {
                application.appComponent.inject(fragment)
            }
        }
    }
}