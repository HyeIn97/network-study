package com.example.domain.proto.usecase

import com.example.domain.proto.model.LikeModel
import com.example.domain.proto.repository.LikeRepository

class DeleteLikeUseCase(private val repository: LikeRepository) {
    suspend operator fun invoke(like: LikeModel) = repository.deleteLike(like)
}