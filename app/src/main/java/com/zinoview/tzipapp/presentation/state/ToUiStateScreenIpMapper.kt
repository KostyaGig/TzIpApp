package com.zinoview.tzipapp.presentation.state

import com.zinoview.tzipapp.core.Abstract
import com.zinoview.tzipapp.core.BaseIp

interface ToUiStateScreenIpMapper : Abstract.IpStateMapper<List<UiStateScreenIp>> {

    class Base(
        private val toUiStateScreenBaseIpMapper: ToUiStateScreenBaseIpMapper,
        private val toUiStateScreenCacheIpMapper: ToUiStateScreenCacheIpMapper
    ) : ToUiStateScreenIpMapper {

        override fun map(baseIp: BaseIp): List<UiStateScreenIp>
            = listOf(baseIp.map(toUiStateScreenBaseIpMapper))

        override fun mapCache(baseIps: List<BaseIp>): List<UiStateScreenIp> {
            return if (baseIps.isEmpty()) {
                listOf(UiStateScreenIp.Cache.Empty())
            } else {
                baseIps.map { uiStateIp ->
                    uiStateIp.map(toUiStateScreenCacheIpMapper)
                }
            }
        }

        override fun map(message: String): List<UiStateScreenIp>
            = listOf(UiStateScreenIp.Failure(message))
    }
}