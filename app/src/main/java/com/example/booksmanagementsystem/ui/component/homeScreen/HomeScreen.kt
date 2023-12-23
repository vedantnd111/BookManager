package com.example.booksmanagementsystem.ui.component.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.booksmanagementsystem.R
import com.example.booksmanagementsystem.navigation.Screens

@Composable
fun HomeScreen(navController: NavController, innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(
            16.dp, Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        HomeScreenButton(text = stringResource(R.string.add_a_book),
            onClick = { navController.navigate(Screens.AddABook.route) })
        HomeScreenButton(text = stringResource(R.string.list_of_books),
            onClick = { navController.navigate(Screens.ListOfBooks.route) })
    }
}
