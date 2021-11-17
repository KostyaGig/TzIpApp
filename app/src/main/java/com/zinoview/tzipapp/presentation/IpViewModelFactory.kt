package com.zinoview.tzipapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zinoview.tzipapp.domain.IpInteractor
import com.zinoview.tzipapp.presentation.state.CommunicationUiStateScreen
import com.zinoview.tzipapp.presentation.state.ToUiStateScreenBaseIpMapper
import com.zinoview.tzipapp.presentation.state.ToUiStateScreenIpMapper

interface IpViewModelFactory : ViewModelProvider.Factory {

    class Base(
        private val interactor: IpInteractor
    ) : IpViewModelFactory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return IpViewModel.Base(
                interactor,
                ToUiStateIpMapper.Base(
                    ToUiIpMapper.Base()
                ),
                ToUiStateScreenIpMapper.Base(
                    ToUiStateScreenBaseIpMapper.Base()
                ),
                CommunicationUiStateScreen.Base()
            ) as T
        }
    }
}