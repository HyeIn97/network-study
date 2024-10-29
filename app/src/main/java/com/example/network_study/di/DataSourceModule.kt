package com.example.network_study.di

import android.content.Context
import com.example.data.api.SearchApi
import com.example.data.proto.datasource.LikeDataSource
import com.example.data.proto.datasourceImpl.LikeDataSourceImpl
import com.example.data.search.datasource.SearchDataSource
import com.example.data.search.datasourceImpl.SearchDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providerSearchDataSource(searchApi: SearchApi): SearchDataSource = SearchDataSourceImpl(searchApi)

    @Provides
    @Singleton
    fun providerLikeDataSource(@ApplicationContext context: Context): LikeDataSource = LikeDataSourceImpl(context)
}