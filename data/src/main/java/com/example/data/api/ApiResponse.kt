package com.example.data.api

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

data class NaverResponse(
    val total: Int,
    val start: Int,
    val display: Int
)

data class NaverApi<T>(
    val response: NaverResponse,
    val items: ArrayList<T>
)
}