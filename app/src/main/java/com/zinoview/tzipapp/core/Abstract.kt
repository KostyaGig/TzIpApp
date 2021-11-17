package com.zinoview.tzipapp.core

interface Abstract {

    interface Ip {

        fun <T> map(mapper: IpMapper<T>) : T
    }

    interface IpMapper<T> : Mapper {

        fun map(ip: String,forwardedFor: String) : T
    }

    interface IpState {

        fun <T> map(mapper: IpStateMapper<T>) : T
    }

    interface IpStateMapper<T> : Mapper {

        fun map(baseIp: BaseIp) : T

        fun map(message: String) : T
    }

    interface Mapper
}