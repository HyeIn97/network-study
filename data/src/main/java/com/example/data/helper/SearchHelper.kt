package com.example.data.helper

import com.example.data.api.NaverApi
import com.example.data.entity.BookEntity
import com.example.domain.model.SearchModel

class SearchHelper {
    fun searchEntityToModel(entity: NaverApi<BookEntity>): SearchModel {
        val bookList = arrayListOf<SearchModel.BookModel>()

        entity.items.map { book ->
            bookList.add(SearchModel.BookModel(book.title ?: "", book.image ?: "", book.author ?: ""))
        }

        return SearchModel(entity.response.total, entity.response.start, entity.response.display, bookList)
    }
}