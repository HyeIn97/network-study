package com.example.domain.proto.usecase

import com.example.domain.proto.repository.LikeRepository
import kotlinx.coroutines.flow.first

class GetLikeUseCase(private val repository: LikeRepository) {
    suspend fun firstGetLike() = repository.getLike().first()
    fun getLike() = repository.getLike()
}