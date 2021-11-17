package com.zinoview.tzipapp.presentation.di.module

import com.zinoview.tzipapp.data.cloud.CloudDataSource
import com.zinoview.tzipapp.data.cloud.CloudIp
import com.zinoview.tzipapp.data.cloud.IpService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    }

    @Provides
    fun provideGson() = GsonConverterFactory.create()

    private companion object {
        private const val BASE_URL = "http://awstest-balancer-1233234915.us-east-2.elb.amazonaws.com/"
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient,gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideIpService(retrofit: Retrofit) : IpService {
        return retrofit.create(IpService::class.java)
    }

    @Provides
    fun provideBaseCloudDataSource(service: IpService) : CloudDataSource<CloudIp> {
        return CloudDataSource.Base(service)
    }

}