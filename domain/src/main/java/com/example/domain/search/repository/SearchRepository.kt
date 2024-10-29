package com.example.domain.search.repository

import com.example.domain.search.model.SearchModel

interface SearchRepository {
    suspend fun getSearch(query: String, start: Int, display: Int): Result<SearchModel>
}