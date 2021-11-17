package com.zinoview.tzipapp.domain

import com.zinoview.tzipapp.core.Abstract

interface ToDomainIpMapper : Abstract.IpMapper<DomainIp> {

    class Base : ToDomainIpMapper {

        override fun map(ip: String, forwardedFor: String): DomainIp
            = DomainIp.Base(ip, forwardedFor)

    }
}