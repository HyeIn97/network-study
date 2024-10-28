package com.example.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.example.data.LikePreferences
import com.example.data.proto.serializer.LikeSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProtoDataStoreModule {
    @Provides
    @Singleton
    fun provideLikeProtoDataStore(@ApplicationContext context: Context): DataStore<LikePreferences> {
        return DataStoreFactory.create(serializer = LikeSerializer, produceFile = { context.dataStoreFile("like.pb") })
    }
}