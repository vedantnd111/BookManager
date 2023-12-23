package com.example.booksmanagementsystem.ui.component.listOfBooks

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.booksmanagementsystem.R
import com.example.booksmanagementsystem.data.db.entities.Book


@Composable
fun BookCard(book: Book, onItemClicked: (book: Book) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = { onItemClicked(book) }),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
//            val image = rememberAsyncImagePainter(model = Uri.parse(book.image))
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, color = Color.Black, shape = RoundedCornerShape(4.dp)),
                painter = painterResource(id = R.drawable.book_image),
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                DisplayBookField(label = "Name: ", text = book.name)
                DisplayBookField(label = "Description: ", text = book.description)
                DisplayBookField(label = "Author: ", text = book.author)
                DisplayBookField(label = "Category: ", text = book.category)
            }
        }
    }
}