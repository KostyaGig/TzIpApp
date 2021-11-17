package com.zinoview.tzipapp.presentation.di.module

import com.zinoview.tzipapp.data.DataStateIp
import com.zinoview.tzipapp.data.IpRepository
import com.zinoview.tzipapp.domain.IpInteractor
import com.zinoview.tzipapp.domain.ToDomainIpMapper
import com.zinoview.tzipapp.domain.ToDomainStateIpMapper
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideIpInteractor(repository: IpRepository<DataStateIp>) : IpInteractor {
        return IpInteractor.Base(
            repository,
            ToDomainStateIpMapper.Base(
                ToDomainIpMapper.Base()
            )
        )
    }
}