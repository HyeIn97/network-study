package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SearchModel
import com.example.domain.usecase.GetSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getSearchUseCase: GetSearchUseCase) : ViewModel() {
    private val _search = MutableStateFlow<SearchModel?>(null)
    val search = _search.asStateFlow()

    fun getSearch(query: String, start: Int, display: Int) = viewModelScope.launch {
        _search.emit(getSearchUseCase(query, start, display).getOrNull())
    }
}