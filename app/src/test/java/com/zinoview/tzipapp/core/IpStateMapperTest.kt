package com.zinoview.tzipapp.core

/***
 * Test for [com.zinoview.tzipapp.core.Abstract.IpStateMapper]
 */

import org.junit.Assert.*
import org.junit.Test

class IpStateMapperTest {

    @Test
    fun success_map_data_ip_state_to_domain() {
        val mapperDomainIpState = MapperDataIpStateToDomain()

        val dataIpState = TestDataIpState.Success(
            TestBaseIp(
                "123.456.678.12","163.456.618.10"
            )
        )

        val expected = TestDomainIpState.Success(
            TestBaseIp(
                "123.456.678.12","163.456.618.10"
            )
        )

        val domainIpState = dataIpState.map(mapperDomainIpState)

        assertEquals(expected,domainIpState)
        assertTrue(domainIpState is TestDomainIpState.Success)
    }

    @Test
    fun failure_map_data_ip_state_to_domain() {
        val mapperDomainIpState = MapperDataIpStateToDomain()

        val dataIpState = TestDataIpState.Failure(
            "No connection"
        )

        val expected = TestDomainIpState.Failure(
            "No connection"
        )

        val domainIpState = dataIpState.map(mapperDomainIpState)

        assertEquals(expected,domainIpState)
        assertTrue(domainIpState is TestDomainIpState.Failure)
    }


    private inner class MapperDataIpStateToDomain : Abstract.IpStateMapper<TestDomainIpState> {
        override fun map(baseIp: BaseIp): TestDomainIpState
                = TestDomainIpState.Success(baseIp)

        override fun map(message: String): TestDomainIpState
                = TestDomainIpState.Failure(message)
    }

    private sealed class TestDataIpState : Abstract.IpState {

        data class Success(
            private val baseIp: BaseIp
        ) : TestDataIpState() {

            override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
                    = mapper.map(baseIp)
        }

        data class Failure(
            private val message: String
        ) : TestDataIpState() {

            override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
                    = mapper.map(message)
        }
    }

    private sealed class TestDomainIpState : Abstract.IpState {

        data class Success(
            private val baseIp: BaseIp
        ) : TestDomainIpState() {

            override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
                    = mapper.map(baseIp)
        }

        data class Failure(
            private val message: String
        ) : TestDomainIpState() {

            override fun <T> map(mapper: Abstract.IpStateMapper<T>): T
                    = mapper.map(message)
        }
    }

    private data class TestBaseIp(
        private val ip: String,
        private val forwarderFor: String
    ) : BaseIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip,forwarderFor)
    }
}

