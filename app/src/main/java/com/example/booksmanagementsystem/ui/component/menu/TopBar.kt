package com.example.booksmanagementsystem.ui.component.menu

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel
import com.example.booksmanagementsystem.navigation.Screens
import com.example.booksmanagementsystem.ui.theme.Pink80


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    navController: NavController = rememberNavController(),
    viewModel: BooksListViewModel
) {
    val context = LocalContext.current
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val isAddBookScreen =
        navController.currentBackStackEntry?.destination?.route == Screens.AddABook.route

    val showBackButton by remember(currentBackStackEntry) {
        derivedStateOf {
            navController.previousBackStackEntry != null
        }
    }

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = "Back"
                    )
                }
            }
        },
        title = {
            Text(
                text = "ManageBooks",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        },
        actions = {
            if (isAddBookScreen) {
                Button(
                    onClick = {
                        if (viewModel.checkValidity()) {
                            Toast.makeText(
                                context, "Book has been added successfully!", Toast.LENGTH_SHORT
                            ).show()
                            viewModel.insertOrReplace()
                            navController.navigate(Screens.ListOfBooks.route)
                        } else {
                            Toast.makeText(
                                context, "Please add all fields!", Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth(0.2f),
                    colors = ButtonDefaults.buttonColors(containerColor = Pink80),
                    shape = RoundedCornerShape(2.dp)
                ) {
                    Text(
                        text = "save",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.Black
                    )
                }
            }
        }
    )
}