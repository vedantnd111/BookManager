package com.example.booksmanagementsystem.data.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.booksmanagementsystem.data.db.entities.Book
import com.example.booksmanagementsystem.data.repository.BooksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BooksListViewModel(private val repository: BooksRepository) : ViewModel() {

    private val _latestBook = mutableStateOf(Book("", "", "", ""))
    private val _bookDetails = mutableStateOf(Book("", "", "", ""))
    val showImage = mutableStateOf(false)

    fun updateLatestBook(book: Book) {
        _latestBook.value = book
    }

    fun insertOrReplace() = CoroutineScope(Dispatchers.Main).launch {
        repository.insertOrReplace(_latestBook.value)
        clearLatestBook()
    }

    fun checkValidity(): Boolean {
        if (_latestBook.value.name.isEmpty()
            || _latestBook.value.author.isEmpty()
            || _latestBook.value.category.isEmpty()
            || _latestBook.value.description.isEmpty()
        ) {
            return false
        }
        return true
    }

    private fun clearLatestBook() {
        _latestBook.value.author = ""
        _latestBook.value.name = ""
        _latestBook.value.description = ""
        _latestBook.value.category = ""
        _latestBook.value.image = null
    }

    fun getLatestBook() = _latestBook

    private fun getBook(id: Int) = CoroutineScope(Dispatchers.Main).launch {
        _bookDetails.value = repository.getBook(id)
    }

    fun getBookDetails(id: Int): MutableState<Book> {
        getBook(id)
        return _bookDetails
    }

    fun getAllBooks() = repository.getAllBooks()

    fun updateLearningsOfABook(bookId: Int, bookLearnings: String?) =
        repository.updateLearningsOfABook(bookId, bookLearnings)
}