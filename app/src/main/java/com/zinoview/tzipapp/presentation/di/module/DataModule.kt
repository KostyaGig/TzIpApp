package com.zinoview.tzipapp.presentation.di.module

import com.zinoview.tzipapp.core.ResourceProvider
import com.zinoview.tzipapp.data.DataStateIp
import com.zinoview.tzipapp.data.ExceptionMapper
import com.zinoview.tzipapp.data.IpRepository
import com.zinoview.tzipapp.data.ToDataIpMapper
import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    fun provideIpRepository(cloudDataSource: CloudDataSource<CloudIp>,resourceProvider: ResourceProvider) : IpRepository<DataStateIp> {
        return IpRepository.Base(
            cloudDataSource,
            ToDataIpMapper.Base(),
            ExceptionMapper.Base(
                resourceProvider
            )
        )
    }
}