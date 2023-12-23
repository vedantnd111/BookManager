package com.example.booksmanagementsystem.ui.component.addABook

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AddLearningsTextField(
    value: String,
    placeholderText: String,
    modifier: Modifier,
    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.body1,
    maxLines: Int = 4,
    onValueChanged: (String) -> Unit,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        maxLines = maxLines,
        modifier = Modifier.fillMaxWidth(0.7f),
        decorationBox = { innerTextField ->
            Box(modifier = modifier) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholderText,
                        color = LocalContentColor.current.copy(ContentAlpha.medium)
                    )
                }
                innerTextField()
            }
        }
    )
}
