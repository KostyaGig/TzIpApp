package com.zinoview.tzipapp.data.cloud

import com.google.gson.annotations.SerializedName
import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp
import com.zinoview.tzipapp.data.cache.CacheIp

interface CloudIp : BaseIp {

    fun mapCache(timeRequest: Double) : CacheIp

    class Base(
        @SerializedName("ip")
        private val ip: String,
        @SerializedName("xForwardedFor")
        private val forwardedFor: String,
    ) : CloudIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip, forwardedFor)

        override fun mapCache(timeRequest: Double): CacheIp
            = CacheIp.Base(
                ip,timeRequest
            )
    }
}