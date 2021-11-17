package com.zinoview.tzipapp.core

import com.zinoview.tzipapp.data.DataIp
import org.junit.Test

/***
 * Test for [com.zinoview.tzipapp.core.Abstract.IpMapper]
 */

import org.junit.Assert.*

class IpMapperTest {

    @Test
    fun test_map_ip_data_to_domain() {
        val testMapperDataIpToDomain = TestMapperDataIpToDomain()

        val dataIp = TestDataIp("123.456.678.12","163.456.618.10")

        val expected = TestDomainIp("123.456.678.12","163.456.618.10")
        val domainIp = dataIp.map(testMapperDataIpToDomain)

        assertEquals(expected,domainIp)
    }

    private inner class TestMapperDataIpToDomain : Abstract.IpMapper<TestDomainIp> {

        override fun map(ip: String, forwardedFor: String): TestDomainIp
            = TestDomainIp(ip, forwardedFor)

    }

    private data class TestDataIp(
        private val ip: String,
        private val forwardedFor: String
    ) : BaseIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
                = mapper.map(ip, forwardedFor)
    }

    private data class TestDomainIp(
        private val ip: String,
        private val forwardedFor: String
    ) : BaseIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip, forwardedFor)
    }
}