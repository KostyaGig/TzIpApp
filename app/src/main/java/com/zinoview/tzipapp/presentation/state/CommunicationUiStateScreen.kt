package com.zinoview.tzipapp.presentation.state

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.zinoview.tzipapp.presentation.core.Observe

interface CommunicationUiStateScreen : Observe<List<UiStateScreenIp>> {

    fun postValue(value: List<UiStateScreenIp>)

    class Base : CommunicationUiStateScreen {

        private val liveData = MutableLiveData<List<UiStateScreenIp>>()

        override fun postValue(value: List<UiStateScreenIp>) {
            liveData.value = value
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<UiStateScreenIp>>)
            = liveData.observe(owner, observer)

    }
}