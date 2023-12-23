package com.example.booksmanagementsystem.ui.component.homeScreen

import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreenButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .widthIn(250.dp)
            .then(modifier)
    ) {
        Text(text = text)
    }
}
