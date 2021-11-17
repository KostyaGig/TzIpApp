package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

sealed class DataStateIp : Abstract.IpState {

    class Success(
        private val baseIp: BaseIp
    ) : DataStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
            = mapper.map(baseIp)
    }

    class Cache(
        private val baseIps: List<BaseIp>
    ) : DataStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
            = mapper.mapCache(baseIps)
    }

    class Failure(
        private val message: String
    ) : DataStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
             = mapper.map(message)
    }
}
