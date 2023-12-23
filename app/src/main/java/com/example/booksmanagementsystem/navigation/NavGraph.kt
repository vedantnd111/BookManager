package com.example.booksmanagementsystem.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel
import com.example.booksmanagementsystem.ui.component.addABook.AddABook
import com.example.booksmanagementsystem.ui.component.bookDetails.DetailsOfABook
import com.example.booksmanagementsystem.ui.component.homeScreen.HomeScreen
import com.example.booksmanagementsystem.ui.component.listOfBooks.ListOfBooks

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: BooksListViewModel,
    innerPadding: PaddingValues
) {

    NavHost(navController = navController, startDestination = Screens.ListOfBooks.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController, innerPadding = innerPadding)
        }
        composable(route = Screens.ListOfBooks.route) {
            ListOfBooks(viewModel = viewModel, navController = navController, innerPadding = innerPadding)
        }
        composable(route = Screens.AddABook.route) {
            AddABook(viewModel = viewModel, innerPadding = innerPadding)
        }
        composable(route = Screens.DetailsOfABook.route) { navBackStackEntry ->
            val bookId = navBackStackEntry.arguments?.getString("bookId")
            if (bookId != null) {
                DetailsOfABook(viewModel = viewModel, bookId = bookId, innerPadding = innerPadding)
            }
        }
    }
}
