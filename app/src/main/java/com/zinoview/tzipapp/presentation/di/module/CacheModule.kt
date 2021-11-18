package com.zinoview.tzipapp.presentation.di.module

import android.content.Context
import androidx.room.Room
import com.zinoview.tzipapp.data.cache.CacheDataSource
import com.zinoview.tzipapp.data.cache.HistoryRequestsIpDao
import com.zinoview.tzipapp.data.cache.HistoryRequestsIpDatabase
import dagger.Module
import dagger.Provides

@Module
class CacheModule {

    private companion object {
        private const val DB_NAME = "requests_ip.db"
    }

    @Provides
    fun provideHistoryRequestsIp(context: Context) : HistoryRequestsIpDatabase {
        return Room.databaseBuilder(
            context,
            HistoryRequestsIpDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    fun provideHistoryRequestsIpDao(database: HistoryRequestsIpDatabase) : HistoryRequestsIpDao
        = database.historyIpDao()

    @Provides
    fun provideCacheDataSource(dao: HistoryRequestsIpDao) : CacheDataSource
        = CacheDataSource.Base(
            dao
        )
}