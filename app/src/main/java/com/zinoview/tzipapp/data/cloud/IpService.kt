package com.zinoview.tzipapp.data.cloud

import retrofit2.http.GET

/**
 * Base url - http://awstest-balancer-1233234915.us-east-2.elb.amazonaws.com
 * */

interface IpService {

    @GET("awstest-service/")
    suspend fun ip() : CloudIp.Base
}