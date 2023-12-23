package com.example.booksmanagementsystem.navigation

sealed class Screens(val route: String) {

    object Home : Screens(route = "home")
    object ListOfBooks : Screens(route = "list_of_books")
    object AddABook: Screens(route = "add_a_book")
    object DetailsOfABook : Screens(route = "detail_of_a_book/{bookId}")
}

