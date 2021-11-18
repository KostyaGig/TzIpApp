package com.zinoview.tzipapp.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CacheIp.Base::class],version = 1,exportSchema = false)
abstract class HistoryRequestsIpDatabase : RoomDatabase() {

    abstract fun historyIpDao() : HistoryRequestsIpDao
}