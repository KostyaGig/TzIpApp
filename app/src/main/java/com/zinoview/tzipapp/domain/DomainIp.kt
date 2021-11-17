package com.zinoview.tzipapp.domain

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface DomainIp : BaseIp {

    class Base(
        private val ip: String,
        private val forwardedFor: String
    ) : DomainIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip, forwardedFor)
    }
}