package com.example.network_study.di

import com.example.domain.search.repository.SearchRepository
import com.example.domain.search.usecase.GetSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object SearchUseCaseModule {
    @Provides
    @ViewModelScoped
    fun providerSearchGetUseCase(searchRepository: SearchRepository) = GetSearchUseCase(searchRepository)
}