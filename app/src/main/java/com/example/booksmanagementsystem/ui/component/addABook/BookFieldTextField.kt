package com.example.booksmanagementsystem.ui.component.addABook

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookFieldTextField(
    value: String,
    placeHolderText: String,
    isSingleLine: Boolean = true,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        label = { Text(text = placeHolderText) },
        placeholder = {
            Text(
                text = placeHolderText,
                fontWeight = FontWeight.W400,
                color = Color.Gray
            )
        },
        shape = RoundedCornerShape(16.dp),
        onValueChange = {
            onValueChange(it)
        },
        singleLine = isSingleLine,
        modifier = Modifier.fillMaxWidth(0.7f)
    )
}

