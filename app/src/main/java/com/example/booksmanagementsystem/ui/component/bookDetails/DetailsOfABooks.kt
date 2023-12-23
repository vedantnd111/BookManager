package com.example.booksmanagementsystem.ui.component.bookDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.booksmanagementsystem.R
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel
import com.example.booksmanagementsystem.ui.component.listOfBooks.DisplayBookField
import com.example.booksmanagementsystem.ui.theme.Pink80
import com.example.booksmanagementsystem.ui.theme.Purple80


@Composable
fun DetailsOfABook(viewModel: BooksListViewModel, bookId: String, innerPadding: PaddingValues) {

    val book = viewModel.getBookDetails(bookId.toInt())
    Surface(modifier = Modifier.fillMaxSize(), color = Pink80) {
        ConstraintLayout(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            val (bookName,
                bookImage,
                bookDescription,
                bookDescriptionLabel,
                bookAuthor,
                bookCategory,
                bookLearningsLabel,
                bookLearnings) = createRefs()
            Text(
                text = book.value.name,
                fontSize = 20.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(bookName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })
            Card(
                modifier = Modifier
                    .size(250.dp, 250.dp)
                    .padding(8.dp)
                    .constrainAs(bookImage) {
                        top.linkTo(bookName.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp,
                )
            ) {
                Image(
                    painterResource(R.drawable.book_image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            DisplayBookField(
                label = "Author: ",
                text = book.value.author,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(bookAuthor) {
                        top.linkTo(bookImage.bottom)
                        start.linkTo(parent.start)
                    }, fontSize = 20.sp
            )
            Text(
                text = book.value.category,
                modifier = Modifier
                    .padding(16.dp)
                    .background(color = Purple80, shape = RoundedCornerShape(4.dp))
                    .constrainAs(bookCategory) {
                        top.linkTo(bookAuthor.top)
                        end.linkTo(parent.end)
                    },
                fontSize = 20.sp,
                fontWeight = Bold
            )
            Text(
                text = "Description: ",
                fontSize = 20.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(bookDescriptionLabel) {
                        top.linkTo(bookAuthor.bottom)
                    })
            Text(
                text = book.value.description,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(bookDescription) {
                        top.linkTo(bookDescriptionLabel.bottom)
                    })

            Text(
                text = "Learnings: ",
                fontSize = 20.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(bookLearningsLabel) {
                        top.linkTo(bookDescription.bottom)
                    })
            Text(text = book.value.learnings ?: "",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(bookLearnings) {
                        top.linkTo(bookLearningsLabel.bottom)
                    })
        }
    }
}
