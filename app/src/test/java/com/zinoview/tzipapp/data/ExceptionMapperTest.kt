package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.core.ResourceProvider
import junit.framework.Assert.assertEquals
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

/**
 * Test for [com.zinoview.tzipapp.data.ExceptionMapper.Test]
 * */

class ExceptionMapperTest {

    @Test
    fun test_map_exception_to_string_message() {
        val exceptionMapper = ExceptionMapper.Test(ResourceProvider.Test())
        var exception: Exception = UnknownHostException()
        var expected = "No connection"
        var actual = exceptionMapper.map(exception)

        assertEquals(expected, actual)

        exception = HttpException(Response.success(null))
        expected = "Some went wrong"
        actual = exceptionMapper.map(exception)

        assertEquals(expected, actual)
    }

}