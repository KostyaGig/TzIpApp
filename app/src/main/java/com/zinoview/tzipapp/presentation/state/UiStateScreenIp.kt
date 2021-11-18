package com.zinoview.tzipapp.presentation.state

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

sealed class UiStateScreenIp {

    open fun handleState(progressBar: ProgressBar,errorTextView: TextView,ipTextView: TextView)
        = Unit


    //todo move to interafce
    open fun bind(ipTextView: TextView, timeRequestTextView: TextView) = Unit
    open fun bind(emptyRequestsTextView: TextView) = Unit

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

    abstract class Cache(
        private val ip: String,
        private val timeRequest: String
    ) : UiStateScreenIp() {

        override fun bind(ipTextView: TextView, timeRequestTextView: TextView) {
            ipTextView.text = ip
            timeRequestTextView.text = timeRequest + SECONDS
        }

        class Base(
            ip: String,
            timeRequest: String
        ) : Cache(ip, timeRequest)

        class Empty : Cache("","")

        private companion object {
            private const val SECONDS = "sc"
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