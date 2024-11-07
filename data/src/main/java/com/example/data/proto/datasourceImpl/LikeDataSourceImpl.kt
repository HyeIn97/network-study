package com.example.data.proto.datasourceImpl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.data.Like
import com.example.data.LikePreferences
import com.example.data.proto.datasource.LikeDataSource
import com.example.data.proto.serializer.LikeSerializer
import com.example.domain.proto.model.LikeModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private val Context.likeDataStore: DataStore<LikePreferences> by dataStore(
    fileName = "like.pb",
    serializer = LikeSerializer
)

private fun LikeModel.toProto() = Like.newBuilder().setTitle(this.title).setImage(this.image).setAuthor(this.author).setLink(this.link).build()

class LikeDataSourceImpl @Inject constructor(@ApplicationContext private val context: Context) : LikeDataSource {
    override fun getLike(): Flow<ArrayList<LikeModel>> = flow {
        context.likeDataStore.data.collect { preferences ->
            val likeList = arrayListOf<LikeModel>()
            preferences.likeList.map { data ->
                likeList.add(LikeModel(data.title, data.image, data.author, data.link))
            }

            emit(likeList)
        }
    }

    override suspend fun setLike(like: LikeModel) {
        context.likeDataStore.updateData { preferences ->
            preferences.toBuilder().addLike(like.toProto()).build()
        }
    }

    override suspend fun deleteLike(like: LikeModel) {
        context.likeDataStore.updateData { preferences ->
            val removeIndex = preferences.likeList.indexOfFirst { it == like.toProto() }
            preferences.toBuilder().removeLike(removeIndex).build()
        }
    }

    override fun isLike(likeUrlKey: String): Flow<Boolean> = flow {
        context.likeDataStore.data.collect { preferences ->
            val likeList = arrayListOf<String>()

            preferences.likeList.map { data ->
                likeList.add(data.link)
            }

            emit(likeList.contains(likeUrlKey))
        }
    }
}