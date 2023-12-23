package com.example.booksmanagementsystem.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksmanagementsystem.data.repository.BooksRepository

@SuppressWarnings("Unchecked")
class BooksListViewModelFactory(private val booksRepository: BooksRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BooksListViewModel(booksRepository) as T
    }
}
