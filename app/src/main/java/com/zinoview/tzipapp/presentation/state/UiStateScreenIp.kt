package com.zinoview.tzipapp.presentation.state

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

sealed class UiStateScreenIp {

    open fun handleState(progressBar: ProgressBar,errorTextView: TextView,ipTextView: TextView)
        = Unit

    object Progress : UiStateScreenIp() {

        override fun handleState(
            progressBar: ProgressBar,
            errorTextView: TextView,
            ipTextView: TextView
        ) {
            errorTextView.visibility = View.INVISIBLE
            ipTextView.visibility = View.VISIBLE
            ipTextView.text = FETCHING_IP_MESSAGE
            progressBar.visibility = View.VISIBLE
        }

        private const val FETCHING_IP_MESSAGE = "Fetching your ip..."
    }

    class Base(
        private val ip: String,
        private val forwardedFor: String
    ) : UiStateScreenIp() {

        override fun handleState(
            progressBar: ProgressBar,
            errorTextView: TextView,
            ipTextView: TextView
        ) {
            errorTextView.visibility = View.INVISIBLE
            progressBar.visibility = View.INVISIBLE
            ipTextView.text = YOUR_IP_TEXT + ip
            ipTextView.visibility = View.VISIBLE
        }

        private companion object {
            private const val YOUR_IP_TEXT = "Your ip: "
        }
    }

    class Cache(
        private val ip: String,
        private val timeRequest: String
    ) : UiStateScreenIp() {

        override fun handleState(
            progressBar: ProgressBar,
            errorTextView: TextView,
            ipTextView: TextView
        ) {

        }

    }

    class Failure(
        private val message: String
    ) : UiStateScreenIp() {

        override fun handleState(
            progressBar: ProgressBar,
            errorTextView: TextView,
            ipTextView: TextView
        ) {
            progressBar.visibility = View.INVISIBLE
            ipTextView.visibility = View.INVISIBLE
            errorTextView.text = message
            errorTextView.visibility = View.VISIBLE
        }

    }
}