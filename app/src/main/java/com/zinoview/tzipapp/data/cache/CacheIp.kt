package com.zinoview.tzipapp.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface CacheIp : BaseIp {

    @Entity(tableName = "cache_ips")
    class Base(
        @ColumnInfo(name = "ip")
        var ip: String,
        @PrimaryKey
        @ColumnInfo(name = "timeRequest")
        var timeRequest: String
    ) : CacheIp {

        override fun <T> map(mapper: Abstract.IpMapper<T>): T
            = mapper.map(ip,timeRequest)
    }
}