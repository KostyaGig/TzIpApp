package com.zinoview.tzipapp.data.cache

import com.zinoview.tzipapp.data.cloud.CloudIp

interface CacheDataSource : MutableDataSource<CloudIp,CacheIp> {

    class Base(
        private val dao: HistoryRequestsIpDao
    ) : CacheDataSource {

        override suspend fun data(): List<CacheIp>
            = dao.historyIp()

        override suspend fun save(data: CloudIp,timeRequest: Double) {
            val cacheIp = data.mapCache(timeRequest)
            dao.insert(cacheIp as CacheIp.Base)
        }
    }
}