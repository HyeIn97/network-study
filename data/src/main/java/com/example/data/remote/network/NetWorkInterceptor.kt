package com.example.data.remote.network

import com.example.data.remote.config.NetworkConfig
import okhttp3.Interceptor
import okhttp3.Response

class NetWorkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response =
            request.newBuilder().addHeader("X-Naver-Client-Id", NetworkConfig.clientId).addHeader("X-Naver-Client-Secret", NetworkConfig.clientSecret)
                .build()
        return chain.proceed(response)
    }
}