package com.zinoview.tzipapp.presentation.state

import com.zinoview.tzipapp.core.Abstract

interface ToUiStateScreenCacheIpMapper : Abstract.IpMapper<UiStateScreenIp> {

    class Base : ToUiStateScreenCacheIpMapper {

        override fun map(ip: String, forwardedFor: String): UiStateScreenIp
            = UiStateScreenIp.Cache.Base(
                ip,forwardedFor
            )
    }
}