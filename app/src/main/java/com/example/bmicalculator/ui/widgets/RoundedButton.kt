package com.example.bmicalculator.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.AppTheme


private val IconButtonSizeModifier = Modifier.height(50.dp)

@Composable
fun RoundedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    contentColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier then IconButtonSizeModifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFe53671),
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.elevation(elevation)
    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Composable
fun RoundedToggleButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier then IconButtonSizeModifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),

    ) {
        Text(text = text, fontSize = 18.sp)
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    AppTheme {
        RoundedButton(text = "Button", onClick = {})
    }
}

@Preview
@Composable
private fun ToggleButtonPreview() {
    AppTheme {
        Row {
            RoundedToggleButton(text = "True", onClick = {})
            EmptyWidth()
            RoundedToggleButton(text = "False", onClick = {})
        }
    }
}

@Composable
fun EmptyWidth() = Spacer(Modifier.width(16.dp))