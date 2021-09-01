package com.example.bmicalculator.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bmicalculator.ui.theme.AppTheme

private val IconButtonSizeModifier = Modifier.size(40.dp)

@Composable
fun RoundIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    elevation: Dp = 4.dp,


    ) {
    Card(
        modifier = modifier
            .padding(all = 4.dp)
            .clickable(onClick = onClick)
            .then(IconButtonSizeModifier),
        shape = CircleShape,
        backgroundColor = backgroundColor,
        elevation = elevation,
        contentColor = Color.Black,


        ) {
        Icon(imageVector, null, tint = Color.Black)
    }
}

@Preview

@Composable
private fun RoundIconPreview() {
    AppTheme {
        RoundIconButton(
            imageVector = Icons.Outlined.Notifications,
            onClick = {}
        )
    }
}