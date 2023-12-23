package com.example.booksmanagementsystem.ui.component.addABook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel

@Composable
fun AddABook(
    viewModel: BooksListViewModel,
    innerPadding: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Add A Book", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        BookFieldTextField(
            value = viewModel.getLatestBook().value.name,
            placeHolderText = "Enter Name"
        ) {
            viewModel.updateLatestBook(
                viewModel.getLatestBook().value.copy(
                    name = it
                )
            )
        }
        BookFieldTextField(
            value = viewModel.getLatestBook().value.author,
            placeHolderText = "Enter Author"
        ) {
            viewModel.updateLatestBook(viewModel.getLatestBook().value.copy(author = it))
        }
        CategoryDropDown(
            value = viewModel.getLatestBook().value.category,
            placeholderText = "Enter Category"
        ) {
            viewModel.updateLatestBook(
                viewModel.getLatestBook().value.copy(
                    category = it
                )
            )
        }
        BookFieldTextField(
            value = viewModel.getLatestBook().value.description,
            placeHolderText = "Enter Description",
            isSingleLine = false
        ) {
            viewModel.updateLatestBook(
                viewModel.getLatestBook().value.copy(
                    description = it
                )
            )
        }
        BookFieldTextField(
            value = viewModel.getLatestBook().value.learnings ?: "",
            placeHolderText = "Enter you learnings\nUse bullet points",
            isSingleLine = false
        ) {
            viewModel.updateLatestBook(viewModel.getLatestBook().value.copy(learnings = it))
        }
//        AddLearningsTextField(
//            value = viewModel.getLatestBook().value.learnings ?: "",
//            placeholderText = "Enter you learnings\nUse bullet points",
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(20.dp))
//                .background(Color.LightGray)
//                .padding(16.dp),
//        ) {
//            viewModel.updateLatestBook(viewModel.getLatestBook().value.copy(learnings = it))
//        }
//        PhotoPicker(viewModel = viewModel)
//        Button(onClick = {
//            if (viewModel.checkValidity()) {
//                Toast.makeText(
//                    context, "Book has been added successfully!", Toast.LENGTH_SHORT
//                ).show()
//                viewModel.insertOrReplace()
//                navController.navigate(Screens.Home.route)
//            } else {
//                Toast.makeText(
//                    context, "Please add all fields!", Toast.LENGTH_SHORT
//                ).show()
//            }
//        }, modifier = modifier) {
//            Text(text = "Save")
//        }
    }
}
