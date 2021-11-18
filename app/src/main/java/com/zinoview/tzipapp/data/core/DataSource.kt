package com.zinoview.tzipapp.data.core

interface DataSource<T> {

    suspend fun data() : T
}