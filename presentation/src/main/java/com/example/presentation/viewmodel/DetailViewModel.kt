package com.example.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.proto.model.LikeModel
import com.example.domain.proto.usecase.DeleteLikeUseCase
import com.example.domain.proto.usecase.IsLikeUseCase
import com.example.domain.proto.usecase.SetLikeUseCase
import com.example.presentation.model.DetailLikeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val isLikeUseCase: IsLikeUseCase,
    private val setLikeUseCase: SetLikeUseCase,
    private val deleteLikeUseCase: DeleteLikeUseCase
) : ViewModel() {
    var like: DetailLikeModel? = null

    private val _likeLiveData = MutableLiveData<Boolean>()
    val likeLiveData get() = _likeLiveData

    fun isLike() = viewModelScope.launch {
        _likeLiveData.value = isLikeUseCase(like?.link ?: "")
    }

    fun setLike() = viewModelScope.launch {
        setLikeUseCase(like?.toProtoModel() ?: LikeModel("", "", "", ""))
    }

    fun deleteLike() = viewModelScope.launch {
        deleteLikeUseCase(like?.toProtoModel() ?: LikeModel("", "", "", ""))
    }

    private fun DetailLikeModel.toProtoModel() = LikeModel(this.title, this.image, this.author, this.link)
}