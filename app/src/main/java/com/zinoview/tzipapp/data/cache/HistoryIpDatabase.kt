package com.zinoview.tzipapp.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CacheIp::class],version = 1,exportSchema = false)
abstract class HistoryIpDatabase : RoomDatabase() {

    abstract fun historyIpDao() : HistoryIpDao
}