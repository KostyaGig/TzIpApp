package com.zinoview.tzipapp.presentation

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface UiIp : BaseIp {

    class Base(
        private val ip: String,
        private val forwardedFor: String
    ) : UiIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip, forwardedFor)
    }
}