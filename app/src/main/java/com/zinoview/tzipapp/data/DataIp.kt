package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface DataIp : BaseIp {

    class Base(
        private val ip: String,
        private val forwardedFor: String
    ) : DataIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip, forwardedFor)
    }
}