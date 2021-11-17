package com.zinoview.tzipapp.presentation.state

import com.zinoview.tzipapp.core.Abstract

interface ToUiStateScreenBaseIpMapper : Abstract.IpMapper<UiStateScreenIp> {

    class Base : ToUiStateScreenBaseIpMapper {

        override fun map(ip: String, forwardedFor: String): UiStateScreenIp
            = UiStateScreenIp.Base(ip,forwardedFor)
    }
}