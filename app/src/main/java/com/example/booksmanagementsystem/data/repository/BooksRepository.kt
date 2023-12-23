package com.example.booksmanagementsystem.data.repository

import com.example.booksmanagementsystem.data.db.BooksDatabase
import com.example.booksmanagementsystem.data.db.entities.Book

class BooksRepository(private val db: BooksDatabase) {

    suspend fun insertOrReplace(item: Book) = db.bookDao().insertOrReplace(item)

    fun updateLearningsOfABook(bookId: Int, bookLearnings: String?) =
        db.bookDao().updateLearnings(bookId, bookLearnings)

    suspend fun getBook(id: Int) = db.bookDao().getBook(id)

    fun getAllBooks() = db.bookDao().getAllBooks()
}
