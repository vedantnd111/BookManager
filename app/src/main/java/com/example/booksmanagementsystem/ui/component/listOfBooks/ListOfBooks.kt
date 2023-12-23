package com.example.booksmanagementsystem.ui.component.listOfBooks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.booksmanagementsystem.data.db.entities.Book
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel
import com.example.booksmanagementsystem.navigation.Screens

@Composable
fun ListOfBooks(
    viewModel: BooksListViewModel,
    navController: NavController,
    innerPadding: PaddingValues
) {

    val listOfBooks = viewModel.getAllBooks().observeAsState()
    var category = ""
    if (listOfBooks.value?.size == 0) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "No books are available", fontSize = 20.sp)
        }
        addBookButton(
            text = "Add Book",
            onClick = { navController.navigate(Screens.AddABook.route) })
    } else if (listOfBooks == null) {
        CircularProgressIndicator()
    } else {
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            listOfBooks.value?.size?.let {
                items(it) { index ->
                    listOfBooks.value?.get(index)?.let { it1 ->
                        if (index == 0 || category != it1.category) {
                            Text(
                                text = " category: ${it1.category}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                            category = it1.category
                        }
                        BookCard(book = it1) { book: Book ->
                            navController.navigate(
                                Screens.DetailsOfABook.route.replace(
                                    oldValue = "{bookId}",
                                    newValue = "${book.id}"
                                )
                            )
                        }
                    }
                }
            }
        }
        addBookButton(
            text = "Add Book",
            onClick = { navController.navigate(Screens.AddABook.route) })
    }
}
