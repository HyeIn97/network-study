package com.example.domain.proto.repository

import com.example.domain.proto.model.LikeModel

interface LikeRepository {
    suspend fun getLike(): Result<ArrayList<LikeModel>>
    suspend fun setLike(like: LikeModel)
    suspend fun deleteLike(like: LikeModel)
    suspend fun isLike(likeUrlKey: String): Result<Boolean>
}