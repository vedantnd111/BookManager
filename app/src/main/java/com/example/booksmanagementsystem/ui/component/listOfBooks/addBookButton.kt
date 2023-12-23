package com.example.booksmanagementsystem.ui.component.listOfBooks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlusOne
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun addBookButton(text: String, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        ExtendedFloatingActionButton(
            onClick = { onClick() },
            icon = { Icon(Icons.Filled.PlusOne, text) },
            text = { Text(text = text) },
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd)
        )
    }
}