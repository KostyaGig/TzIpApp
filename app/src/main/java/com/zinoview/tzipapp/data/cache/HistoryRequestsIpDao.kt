package com.zinoview.tzipapp.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryRequestsIpDao {

    @Query("select * from cache_ips")
    fun historyIp(): List<CacheIp.Base>

    @Insert
    fun insert(data: CacheIp.Base)
}