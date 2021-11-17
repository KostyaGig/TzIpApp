package com.zinoview.tzipapp.domain

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface ToDomainStateIpMapper : Abstract.IpStateMapper<DomainStateIp> {

    class Base(
        private val toDomainIpMapper: ToDomainIpMapper
    ) : ToDomainStateIpMapper {

        override fun map(baseIp: BaseIp): DomainStateIp
            = DomainStateIp.Success(
                baseIp.map(toDomainIpMapper)
            )

        override fun mapCache(baseIps: List<BaseIp>): DomainStateIp
            = DomainStateIp.Cache(
                baseIps.map { dataIp -> dataIp.map(toDomainIpMapper) }
            )

        override fun map(message: String): DomainStateIp
            = DomainStateIp.Failure(message)
    }
}