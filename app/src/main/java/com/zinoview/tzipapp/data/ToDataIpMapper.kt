package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.core.Abstract

interface ToDataIpMapper : Abstract.IpMapper<DataIp> {

    class Base : ToDataIpMapper {

        override fun map(ip: String, forwardedFor: String): DataIp
            = DataIp.Base(ip, forwardedFor)

    }
}