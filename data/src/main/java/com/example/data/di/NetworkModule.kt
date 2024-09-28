package com.example.data.di

import com.example.data.network.NetWorkInterceptor
import com.example.data.network.NetworkConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providerOkHttpClick(interceptor: NetWorkInterceptor): OkHttpClient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun providerNetwork(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(NetworkConfig.BaseUrl).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
}