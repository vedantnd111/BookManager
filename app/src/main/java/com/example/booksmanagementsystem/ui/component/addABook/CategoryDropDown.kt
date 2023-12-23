package com.example.booksmanagementsystem.ui.component.addABook

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.booksmanagementsystem.CATEGORIES

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropDown(value: String, placeholderText: String, onValueChange: (String) -> Unit) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    var category by remember {
        mutableStateOf("Select Category:")
    }

    ExposedDropdownMenuBox(expanded = isExpanded, onExpandedChange = { isExpanded = !isExpanded }) {

        OutlinedTextField(
            value = if (value != "") {
                value
            } else placeholderText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(0.7f),
            shape = RoundedCornerShape(16.dp),
        )

        ExposedDropdownMenu(expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            for (item in CATEGORIES) {
                DropdownMenuItem(
                    text = {
                        Text(text = item)
                    },
                    onClick = {
                        isExpanded = false
                        onValueChange(item)
                    }
                )
            }
        }
    }
}
