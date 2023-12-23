package com.example.booksmanagementsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.booksmanagementsystem.data.db.BooksDatabase
import com.example.booksmanagementsystem.data.repository.BooksRepository
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModelFactory
import com.example.booksmanagementsystem.navigation.NavGraph
import com.example.booksmanagementsystem.ui.component.menu.AppTopBar
import com.example.booksmanagementsystem.ui.theme.BooksManagementSystemTheme

class MainActivity : ComponentActivity() {

    private lateinit var repository: BooksRepository
    private val viewModel by viewModels<BooksListViewModel> {
        BooksListViewModelFactory(repository)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = BooksRepository(BooksDatabase(this))
        setContent {
            BooksManagementSystemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val snackbarHostState = remember { SnackbarHostState() }
                    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        topBar = {
                            AppTopBar(navController, viewModel)
                        }) { innerPadding ->
                        NavGraph(
                            navController = navController,
                            viewModel = viewModel,
                            innerPadding = innerPadding
                        )
                    }
                }
            }
        }
    }
}

