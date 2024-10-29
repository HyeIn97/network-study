package com.example.data.proto.repositoryImpl

import com.example.data.proto.datasource.LikeDataSource
import com.example.domain.proto.model.LikeModel
import com.example.domain.proto.repository.LikeRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class LikeRepositoryImpl @Inject constructor(private val dataSource: LikeDataSource) : LikeRepository {
    override suspend fun getLike(): Result<ArrayList<LikeModel>> = Result.success(dataSource.getLike().first())

    override suspend fun setLike(like: LikeModel) {
        dataSource.setLike(like)
    }

    override suspend fun deleteLike(like: LikeModel) {
        dataSource.deleteLike(like)
    }
}