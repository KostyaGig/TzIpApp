package com.zinoview.tzipapp.presentation

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface ToUiStateIpMapper : Abstract.IpStateMapper<UiStateIp> {

    class Base(
        private val toUiIpMapper: ToUiIpMapper
    ) : ToUiStateIpMapper {

        override fun map(baseIp: BaseIp): UiStateIp =
            UiStateIp.Success(
                baseIp.map(toUiIpMapper)
            )

        override fun mapCache(baseIps: List<BaseIp>): UiStateIp
             = UiStateIp.Cache(baseIps)

        override fun map(message: String): UiStateIp
            = UiStateIp.Failure(message)
    }
}