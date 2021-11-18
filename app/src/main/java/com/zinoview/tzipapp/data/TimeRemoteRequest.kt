package com.zinoview.tzipapp.data

import com.zinoview.tzipapp.presentation.core.log
import java.text.DecimalFormat

interface TimeRemoteRequest {

    fun start()

    fun drop()

    fun time() : Double

    class Base : TimeRemoteRequest {

        private var time: Long = 0

        override fun start() {
            time  = System.currentTimeMillis()
        }

        override fun drop() {
            time = 0
        }

        override fun time(): Double {
            val currentTime = System.currentTimeMillis()
            val differenceTimeRequestInMillis = (currentTime - time)
            val timeRequestInMillis: Double = differenceTimeRequestInMillis.toDouble()
            val timeRequestInMillisDivedBySeconds = timeRequestInMillis/MILLIS_IN_SECOND
            val decimalFormat = DecimalFormat(DECIMAL_PATTERN)
            val result = decimalFormat.format(timeRequestInMillisDivedBySeconds)
            drop()
            return result.toDouble()
        }

        private companion object {
            private const val DECIMAL_PATTERN = "#.###"
            private const val MILLIS_IN_SECOND = 1000
        }

    }
}