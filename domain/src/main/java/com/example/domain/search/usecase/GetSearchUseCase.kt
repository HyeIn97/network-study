package com.example.domain.search.usecase

import com.example.domain.search.repository.SearchRepository

class GetSearchUseCase(private val searchRepository: SearchRepository) {
    suspend operator fun invoke(query: String, start: Int, display: Int) = searchRepository.getSearch(query, start, display)
}