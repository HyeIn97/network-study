package com.example.data.search.helper

import com.example.data.api.NaverApi
import com.example.data.search.entity.BookEntity
import com.example.domain.search.model.SearchModel

class SearchHelper {
    fun searchEntityToModel(entity: NaverApi<BookEntity>): SearchModel {
        val bookList = arrayListOf<SearchModel.BookModel>()

        entity.items.map { book ->
            bookList.add(SearchModel.BookModel(book.title ?: "", book.image ?: "", book.author ?: "", book.link ?: ""))
        }

        return SearchModel(entity.total, entity.start, entity.display, bookList)
    }
}