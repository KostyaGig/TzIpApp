package com.zinoview.tzipapp.presentation.di.module

import com.zinoview.tzipapp.core.ResourceProvider
import com.zinoview.tzipapp.data.*
import com.zinoview.tzipapp.data.cache.CacheDataSource
import com.zinoview.tzipapp.data.cache.HistoryRequestsIpDao
import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class,CacheModule::class])
class DataModule {

    @Provides
    fun provideIpRepository(cloudDataSource: CloudDataSource<CloudIp>,resourceProvider: ResourceProvider,dao: HistoryRequestsIpDao) : IpRepository<DataStateIp> {
        return IpRepository.Base(
            cloudDataSource,
            CacheDataSource.Base(
                dao
            ),
            ToDataIpMapper.Base(),
            ExceptionMapper.Base(
                resourceProvider
            ),
            TimeRemoteRequest.Base()
        )
    }
}