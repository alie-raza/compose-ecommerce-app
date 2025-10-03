package com.alidev.ecommerceapplication.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.alidev.ecommerceapplication.ui.theme.Orange
import com.alidev.ecommerceapplication.ui.theme.TextColor


@Composable
fun CustomTextField(
    placeholder: String, trailingIcon: Int, label: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    errorState: MutableState<Boolean>,
    onChanged: (TextFieldValue) -> Unit
) {
    //state
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onChanged(newText)
        },
        placeholder = {
            Text(text = placeholder)
        },
        label = { Text(text = label) },
        shape = RoundedCornerShape(1.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(id = trailingIcon),
                contentDescription = "TextField Email"
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            trailingIconColor = if (text.text.isNotEmpty()) Orange else TextColor,
            cursorColor = Orange,
            focusedBorderColor = Orange,
            focusedLabelColor = Orange,
            textColor = TextColor
        ),
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        isError = errorState.value,
        modifier = Modifier
            .fillMaxWidth()
    )
}