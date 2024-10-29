package com.example.data.search.repositoryImpl

import com.example.data.search.datasource.SearchDataSource
import com.example.data.search.helper.SearchHelper
import com.example.domain.search.model.SearchModel
import com.example.domain.search.repository.SearchRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchDataSource: SearchDataSource) : SearchRepository {
    private val helper = SearchHelper()

    override suspend fun getSearch(query: String, start: Int, display: Int): Result<SearchModel>  {
      return Result.success(helper.searchEntityToModel(searchDataSource.getSearch(query, start, display).first()))
    }
}