package com.example.domain.proto.repository

import com.example.domain.proto.model.LikeModel
import kotlinx.coroutines.flow.Flow

interface LikeRepository {
    fun getLike(): Flow<ArrayList<LikeModel>>
    suspend fun setLike(like: LikeModel)
    suspend fun deleteLike(like: LikeModel)
    fun isLike(likeUrlKey: String): Flow<Boolean>
}