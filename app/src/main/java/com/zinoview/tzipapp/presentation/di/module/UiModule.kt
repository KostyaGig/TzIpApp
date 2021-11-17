package com.zinoview.tzipapp.presentation.di.module

import com.zinoview.tzipapp.domain.IpInteractor
import com.zinoview.tzipapp.presentation.IpViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UiModule {

    @Provides
    fun provideIpViewModelFactory(interactor: IpInteractor) : IpViewModelFactory {
        return IpViewModelFactory.Base(interactor)
    }
}