package com.example.data.search.datasource

import com.example.data.api.NaverApi
import com.example.data.search.entity.BookEntity
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {
    fun getSearch(query: String, start: Int, display: Int): Flow<NaverApi<BookEntity>>
}