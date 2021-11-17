package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import java.lang.Exception

interface IpRepository<T> {

    suspend fun ip() : T

    class Base(
        private val cloudDataSource: CloudDataSource<CloudIp>,
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