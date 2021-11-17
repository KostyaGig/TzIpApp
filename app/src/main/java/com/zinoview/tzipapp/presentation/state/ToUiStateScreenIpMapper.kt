package com.zinoview.tzipapp.presentation.state

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface ToUiStateScreenIpMapper : Abstract.IpStateMapper<UiStateScreenIp> {

    class Base(
        private val toUiStateScreenBaseIpMapper: ToUiStateScreenBaseIpMapper
    ) : ToUiStateScreenIpMapper {

        override fun map(baseIp: BaseIp): UiStateScreenIp
            = baseIp.map(toUiStateScreenBaseIpMapper)

        override fun map(message: String): UiStateScreenIp
            = UiStateScreenIp.Failure(message)


    }
}