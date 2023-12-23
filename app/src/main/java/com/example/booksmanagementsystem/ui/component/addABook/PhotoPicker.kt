package com.example.booksmanagementsystem.ui.component.addABook

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.booksmanagementsystem.data.db.entities.Book
import com.example.booksmanagementsystem.data.viewmodels.BooksListViewModel

@Composable
fun PhotoPicker(viewModel: BooksListViewModel) {
    val context = LocalContext.current
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            viewModel.updateLatestBook(viewModel.getLatestBook().value.copy(image = uri.toString()))
        })
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        ShowSelectedImage(
            latestBook = viewModel.getLatestBook().value,
            isVisible = viewModel.showImage.value
        )
        Button(
            onClick = {
                photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                viewModel.showImage.value = true
            },
            modifier = Modifier
                .widthIn(max = 150.dp)
                .heightIn(max = 50.dp)
        ) {
            Text(text = "Pick photo")
        }
    }
}

@Composable
fun ShowSelectedImage(latestBook: Book, isVisible: Boolean = false) {
    if (isVisible && latestBook.image != null) {
        AsyncImage(
            model = Uri.parse(latestBook.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }
}
