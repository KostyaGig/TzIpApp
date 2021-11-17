package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.data.cache.CacheDataSource
import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import java.lang.Exception

interface IpRepository<T> {

    suspend fun ip() : T

    suspend fun historyIp() : T

    class Base(
        private val cloudDataSource: CloudDataSource<CloudIp>,
        private val cacheDataSource: CacheDataSource,
        private val toDataIpMapper: ToDataIpMapper,
        private val exceptionMapper: ExceptionMapper<String>
    ) : IpRepository<DataStateIp> {

        override suspend fun ip(): DataStateIp {
            return try {
                val cloudIp = cloudDataSource.ip()
                val dataIp = cloudIp.map(toDataIpMapper)
                DataStateIp.Success(dataIp)
            } catch (e: Exception) {
                val errorMessage = exceptionMapper.map(e)
                DataStateIp.Failure(errorMessage)
            }
        }

        override suspend fun historyIp(): DataStateIp {
            val cacheIps = cacheDataSource.historyIp()
            val dataIps = cacheIps.map { cacheIp -> cacheIp.map(toDataIpMapper) }
            return DataStateIp.Cache(dataIps)
        }
    }

    class Test(
        private val testCloudDataSource: CloudDataSource<String>
    ) : IpRepository<Test.TestDataStateIp> {

        private var isFailure = false

        override suspend fun ip(): TestDataStateIp {
            val ip = testCloudDataSource.ip()

            return if (isFailure) {
                isFailure = false
                TestDataStateIp.Failure("No connection")
            } else {
                isFailure = true
                TestDataStateIp.Success(ip)
            }
        }

        //todo make test
        override suspend fun historyIp(): TestDataStateIp
            = TestDataStateIp.Failure("")

        sealed class TestDataStateIp {

            data class Success(
                private val ip: String
            ) : TestDataStateIp()

            data class Failure(
                private val message: String
            ) : TestDataStateIp()
        }
    }
}