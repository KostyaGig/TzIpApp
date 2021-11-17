package com.zinoview.tzipapp.data

/**
 * Test for [com.zinoview.tzipapp.core.ResourceProvider.Test]
 */

import com.zinoview.tzipapp.R
import com.zinoview.tzipapp.core.ResourceProvider


import org.junit.Assert.*
import org.junit.Test
class ResourceProviderTest {

    @Test
    fun test_map_string_id_to_string() {
        val resourceProvider = ResourceProvider.Test()
        var expected = "No connection"
        var actual = resourceProvider.string(R.string.no_connection_text)

        assertEquals(expected, actual)

        expected = "Some went wrong"
        actual = resourceProvider.string(R.string.some_went_wrong_text)

        assertEquals(expected, actual)
    }

}