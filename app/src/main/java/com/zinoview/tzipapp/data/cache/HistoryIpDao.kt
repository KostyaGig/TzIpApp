package com.zinoview.tzipapp.data.cache

import androidx.room.Dao
import androidx.room.Query

@Dao
interface HistoryIpDao {

    @Query("select * from cache_ips")
    fun historyIp(): List<CacheIp.Base>
}