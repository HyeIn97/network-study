package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.proto.model.LikeModel
import com.example.domain.proto.usecase.DeleteLikeUseCase
import com.example.domain.proto.usecase.GetLikeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikeViewModel @Inject constructor(private val getLikeUseCase: GetLikeUseCase, private val deleteLikeUseCase: DeleteLikeUseCase) : ViewModel() {
    private val _like = MutableStateFlow<ArrayList<LikeModel>>(arrayListOf())
    val like = _like.asSharedFlow()

    fun getLike() = viewModelScope.launch {
        _like.emit(getLikeUseCase().getOrNull() ?: arrayListOf())
    }

    private val _deletePosition = MutableSharedFlow<Int>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val deletePosition = _deletePosition.asSharedFlow()

    fun deleteLike(position: Int, data: LikeModel) = viewModelScope.launch {
        deleteLikeUseCase(data).run {
            _deletePosition.emit(position)
        }
    }
}