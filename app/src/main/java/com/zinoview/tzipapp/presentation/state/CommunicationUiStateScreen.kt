package com.zinoview.tzipapp.presentation.state

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zinoview.tzipapp.presentation.core.Observe

interface CommunicationUiStateScreen : Observe<UiStateScreenIp> {

    fun postValue(value: UiStateScreenIp)

    class Base : CommunicationUiStateScreen {

        private val liveData = MutableLiveData<UiStateScreenIp>()

        override fun postValue(value: UiStateScreenIp) {
            liveData.value = value
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<UiStateScreenIp>)
            = liveData.observe(owner, observer)

    }
}