package com.zinoview.tzipapp.data.cloud

import com.zinoview.tzipapp.data.core.DataSource

interface CloudDataSource<T> : DataSource<T> {

    class Base(
        private val ipService: IpService
    ) : CloudDataSource<CloudIp> {

        override suspend fun data(): CloudIp
            = ipService.ip()
    }

    class Test : CloudDataSource<String> {

        override suspend fun data(): String
            = MOCK_IP

        private companion object {
            private const val MOCK_IP = "243.123.157.98"
        }
    }
}