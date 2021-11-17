package com.zinoview.tzipapp.data.cloud

import com.google.gson.annotations.SerializedName
import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface CloudIp : BaseIp {

    class Base(
        @SerializedName("ip")
        private val ip: String,
        @SerializedName("xForwardedFor")
        private val forwardedFor: String,
    ) : CloudIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip, forwardedFor)

    }
}