package com.zinoview.tzipapp.presentation

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

sealed class UiStateIp : Abstract.IpState {

    class Success(
        private val baseIp: BaseIp
    ) : UiStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
            = mapper.map(baseIp)
    }

    class Failure(
        private val message: String
    ) : UiStateIp() {

        override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
             = mapper.map(message)
    }
}
