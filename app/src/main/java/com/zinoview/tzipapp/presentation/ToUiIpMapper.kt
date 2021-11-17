package com.zinoview.tzipapp.presentation

import com.zinoview.tzipapp.core.Abstract

interface ToUiIpMapper : Abstract.IpMapper<UiIp> {

    class Base : ToUiIpMapper {

        override fun map(ip: String, forwardedFor: String): UiIp
            = UiIp.Base(ip, forwardedFor)

    }
}