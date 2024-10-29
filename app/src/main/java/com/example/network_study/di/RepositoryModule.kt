package com.example.network_study.di

import com.example.data.search.datasource.SearchDataSource
import com.example.data.proto.datasource.LikeDataSource
import com.example.data.proto.repositoryImpl.LikeRepositoryImpl
import com.example.data.search.repositoryImpl.SearchRepositoryImpl
import com.example.domain.proto.repository.LikeRepository
import com.example.domain.search.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providerSearchRepository(searchDataSource: SearchDataSource): SearchRepository = SearchRepositoryImpl(searchDataSource)

    @Provides
    @Singleton
    fun providerLikeRepository(likeDataSource: LikeDataSource): LikeRepository = LikeRepositoryImpl(likeDataSource)
}
