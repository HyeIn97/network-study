package com.example.data.proto.datasource

import com.example.domain.proto.model.LikeModel
import kotlinx.coroutines.flow.Flow

interface LikeDataSource {
    fun getLike(): Flow<ArrayList<LikeModel>>
    suspend fun setLike(like: LikeModel)
    suspend fun deleteLike(like: LikeModel)
    fun isLike(likeUrlKey: String): Flow<Boolean>
}