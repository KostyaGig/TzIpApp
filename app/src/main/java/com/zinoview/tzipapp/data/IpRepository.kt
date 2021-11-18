package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.data.cache.CacheDataSource
import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import kotlinx.coroutines.delay
import java.lang.Exception

interface IpRepository<T> {

    suspend fun ip() : T

    suspend fun historyRequestsIp() : T

    class Base(
        private val cloudDataSource: CloudDataSource<CloudIp>,
        private val cacheDataSource: CacheDataSource,
        private val toDataIpMapper: ToDataIpMapper,
        private val exceptionMapper: ExceptionMapper<String>,
        private val timeRemoteRequest: TimeRemoteRequest
    ) : IpRepository<DataStateIp> {

        override suspend fun ip(): DataStateIp {
            return try {
                timeRemoteRequest.start()
                delay(DELAY.toLong())
                val cloudIp = cloudDataSource.data()
                val timeRequest = timeRemoteRequest.time()
                cacheDataSource.save(cloudIp,timeRequest)
                val dataIp = cloudIp.map(toDataIpMapper)
                DataStateIp.Success(dataIp)
            } catch (e: Exception) {
                val errorMessage = exceptionMapper.map(e)
                DataStateIp.Failure(errorMessage)
            }
        }

        override suspend fun historyRequestsIp(): DataStateIp {
            val cacheIps = cacheDataSource.data().reversed()
            val dataIps = cacheIps.map { cacheIp -> cacheIp.map(toDataIpMapper) }
            return DataStateIp.Cache(dataIps)
        }

        private companion object {
            private const val DELAY = 1000
        }
    }

    class Test(
        private val testCloudDataSource: CloudDataSource<String>
    ) : IpRepository<Test.TestDataStateIp> {

        private var isFailure = false

        override suspend fun ip(): TestDataStateIp {
            val ip = testCloudDataSource.data()

            return if (isFailure) {
                isFailure = false
                TestDataStateIp.Failure("No connection")
            } else {
                isFailure = true
                TestDataStateIp.Success(ip)
            }
        }
        sealed class TestDataStateIp {

            data class Success(
                private val ip: String
            ) : TestDataStateIp()

            data class Failure(
                private val message: String
            ) : TestDataStateIp()
        }

        override suspend fun historyRequestsIp(): TestDataStateIp
                = TestDataStateIp.Failure("")
    }
}