package com.zinoview.tzipapp.data.cache

import com.zinoview.tzipapp.data.core.DataSource

interface MutableDataSource<S,T> : DataSource<List<T>> {

    suspend fun save(data: S,timeRequest: Double)
}