package com.zinoview.tzipapp.data.cache

interface CacheDataSource {

    suspend fun historyIp() : List<CacheIp>

    class Base(
        private val dao: HistoryIpDao
    ) : CacheDataSource {

        override suspend fun historyIp(): List<CacheIp> {
            return dao.historyIp()
        }
    }
}