package com.example.booksmanagementsystem.ui.component.listOfBooks

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun DisplayBookField(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified
) {
    Row(modifier = modifier) {
        Text(
            text = label,
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontStyle = FontStyle(700)),
            maxLines = 1,
            fontSize = fontSize
        )
        Text(
            text = text,
            modifier = Modifier.padding(top = 2.dp),
            maxLines = 1,
            fontSize = fontSize
        )
    }
}