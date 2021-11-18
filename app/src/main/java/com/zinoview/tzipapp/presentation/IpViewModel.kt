package com.zinoview.tzipapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zinoview.tzipapp.domain.DomainStateIp
import com.zinoview.tzipapp.domain.IpInteractor
import com.zinoview.tzipapp.presentation.core.Observe
import com.zinoview.tzipapp.presentation.state.CommunicationUiStateScreen
import com.zinoview.tzipapp.presentation.state.ToUiStateScreenIpMapper
import com.zinoview.tzipapp.presentation.state.UiStateScreenIp
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface IpViewModel : Observe<List<UiStateScreenIp>> {

    fun ip()

    fun historyRequestsIp()

    class Base(
        private val interactor: IpInteractor,
        private val toUiStateIpMapper: ToUiStateIpMapper,
        private val toUiStateScreenIpMapper: ToUiStateScreenIpMapper,
        private val communicationUiStateScreen: CommunicationUiStateScreen,
        private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
    ) : IpViewModel,ViewModel() {

        override fun ip() {
            communicationUiStateScreen.postValue(listOf(UiStateScreenIp.Progress))
            viewModelScope.launch(defaultDispatcher) {
                val domainIp = interactor.ip()
                doAction(domainIp)
            }

        }

        override fun historyRequestsIp() {
            communicationUiStateScreen.postValue(listOf(UiStateScreenIp.Progress))
            viewModelScope.launch(defaultDispatcher) {
                val domainIp = interactor.historyRequestsIp()
                doAction(domainIp)
            }
        }

        private suspend fun doAction(domainIp: DomainStateIp) {
            val uiStateIp = domainIp.map(toUiStateIpMapper)
            val uiStateScreenIp = uiStateIp.map(toUiStateScreenIpMapper)

            withContext(Dispatchers.Main) {
                communicationUiStateScreen.postValue(uiStateScreenIp)
            }
        }

        override fun observe(owner: LifecycleOwner, observer: Observer<List<UiStateScreenIp>>)
            = communicationUiStateScreen.observe(owner,observer)
    }
}