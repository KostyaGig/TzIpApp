package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.data.cloud.CloudDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertEquals

/**
 * Test for [com.zinoview.tzipapp.data.IpRepository.Test]
 */

class IpRepositoryTest {

    private lateinit var repository: IpRepository<IpRepository.Test.TestDataStateIp>

    @Before
    fun setUp() {
        val testCloudDataSource = CloudDataSource.Test()
        repository = IpRepository.Test(testCloudDataSource)
    }

    @Test
    fun test_success_fetching_ip() = runBlocking {
        val expected = IpRepository.Test.TestDataStateIp.Success("243.123.157.98")
        val actual = repository.ip()

        assertEquals(expected, actual)
    }

    @Test
    fun test_failure_fetching_ip() = runBlocking {
        val expected = IpRepository.Test.TestDataStateIp.Failure("No connection")
        repository.ip()
        val actual = repository.ip()

        assertEquals(expected, actual)
    }
}