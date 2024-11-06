package com.example.data.proto.repositoryImpl

import com.example.data.proto.datasource.LikeDataSource
import com.example.domain.proto.model.LikeModel
import com.example.domain.proto.repository.LikeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(private val dataSource: LikeDataSource) : LikeRepository {
    override fun getLike(): Flow<ArrayList<LikeModel>> = dataSource.getLike()
    override suspend fun setLike(like: LikeModel) = dataSource.setLike(like)
    override suspend fun deleteLike(like: LikeModel) = dataSource.deleteLike(like)
    override fun isLike(likeUrlKey: String): Flow<Boolean> = dataSource.isLike(likeUrlKey)
}