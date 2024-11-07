package com.example.network_study.di

import com.example.domain.proto.repository.LikeRepository
import com.example.domain.proto.usecase.DeleteLikeUseCase
import com.example.domain.proto.usecase.GetLikeUseCase
import com.example.domain.proto.usecase.IsLikeUseCase
import com.example.domain.proto.usecase.SetLikeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ProtoUseCaseModule {
    @Provides
    @ViewModelScoped
    fun providerLikeGetUseCase(repository: LikeRepository) = GetLikeUseCase(repository)

    @Provides
    @ViewModelScoped
    fun providerLikeSetUseCase(repository: LikeRepository) = SetLikeUseCase(repository)

    @Provides
    @ViewModelScoped
    fun providerLikeDeleteUseCase(repository: LikeRepository) = DeleteLikeUseCase(repository)

    @Provides
    @ViewModelScoped
    fun providerIsLikeUseCase(repository: LikeRepository) = IsLikeUseCase(repository)
}