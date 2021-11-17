package com.zinoview.tzipapp.domain
import com.zinoview.tzipapp.data.DataStateIp
import com.zinoview.tzipapp.data.IpRepository

interface IpInteractor {

    suspend fun ip() : DomainStateIp

    class Base(
        private val repository: IpRepository<DataStateIp>,
        private val toDomainStateIpMapper: ToDomainStateIpMapper
    ) : IpInteractor {

        override suspend fun ip(): DomainStateIp {
            val dataIp = repository.ip()
            return dataIp.map(toDomainStateIpMapper)
        }

    }
}