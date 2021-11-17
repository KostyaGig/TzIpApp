package com.zinoview.tzipapp.domain

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp
import com.zinoview.tzipapp.data.DataStateIp

sealed class DomainStateIp : Abstract.IpState {

    class Success(
        private val baseIp: BaseIp
    ) : DomainStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
            = mapper.map(baseIp)
    }

    class Cache(
        private val baseIps: List<BaseIp>
    ) : DomainStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
                = mapper.mapCache(baseIps)
    }


    class Failure(
        private val message: String
    ) : DomainStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
             = mapper.map(message)
    }
}
