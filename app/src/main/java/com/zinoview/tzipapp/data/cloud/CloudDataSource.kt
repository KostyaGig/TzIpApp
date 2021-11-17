package com.zinoview.tzipapp.data.cloud

interface CloudDataSource<T> {

    suspend fun ip() : T

    class Base(
        private val ipService: IpService
    ) : CloudDataSource<CloudIp> {

        override suspend fun ip(): CloudIp
            = ipService.ip()
    }

    class Test : CloudDataSource<String> {

        override suspend fun ip(): String
            = MOCK_IP

        private companion object {
            private const val MOCK_IP = "243.123.157.98"
        }
    }
}