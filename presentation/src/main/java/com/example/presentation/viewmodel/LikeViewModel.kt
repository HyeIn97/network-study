package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.proto.model.LikeModel
import com.example.domain.proto.usecase.GetLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikeViewModel @Inject constructor(private val getLikeUseCase: GetLikeUseCase) : ViewModel() {
    private val _like = MutableStateFlow<ArrayList<LikeModel>>(arrayListOf())
    val like = _like.asStateFlow()

    fun getLike() = viewModelScope.launch {
        _like.emit(getLikeUseCase().getOrNull() ?: arrayListOf())
    }
}