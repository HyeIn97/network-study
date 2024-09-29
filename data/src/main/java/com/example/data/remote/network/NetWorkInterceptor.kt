package com.example.data.remote.network

import com.example.data.remote.config.NetworkConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetWorkInterceptor @Inject constructor(private val networkConfig: NetworkConfig) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response =
            request.newBuilder().addHeader("X-Naver-Client-Id", networkConfig.clientId).addHeader("X-Naver-Client-Secret", networkConfig.clientSecret)
                .build()
        return chain.proceed(response)
    }
}