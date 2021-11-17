package com.zinoview.tzipapp.presentation.state

import com.zinoview.tzipapp.presentation.core.log


sealed class UiStateScreenIp {

    abstract fun handleState()

    object Progress : UiStateScreenIp() {

        override fun handleState() {
            log("Progress...")
        }
    }

    class Base(
        private val ip: String,
        private val forwardedFor: String
    ) : UiStateScreenIp() {

        override fun handleState() {
            log("Base state ip $ip")
        }
    }

    class Failure(
        private val message: String
    ) : UiStateScreenIp() {

        override fun handleState() {
            log("Failure state message $message")
        }
    }
}