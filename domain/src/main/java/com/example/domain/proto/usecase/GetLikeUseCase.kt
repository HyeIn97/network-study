package com.example.domain.proto.usecase

import com.example.domain.proto.repository.LikeRepository

class GetLikeUseCase(private val repository: LikeRepository) {
    suspend operator fun invoke() = repository.getLike()
}