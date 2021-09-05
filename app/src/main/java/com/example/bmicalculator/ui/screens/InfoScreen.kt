package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.ui.theme.AppTheme
import com.example.bmicalculator.ui.theme.accentColor
import com.example.bmicalculator.ui.widgets.RoundedCard
import com.example.bmicalculator.ui.widgets.textStyle
import com.example.bmicalculator.util.BMICalculator

@Composable
fun InfoScreen(navController: NavHostController) {

    Scaffold(

        topBar = {

            Row(
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

            ) {
                IconButton(
                    onClick = {
                        navController.navigate("weight_height_screen") {
                            popUpTo("info_screen") {
                                inclusive = true

                            }
                        }
                        navController.popBackStack()
                    },

                    ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        modifier = Modifier.background(Color.Transparent)
                    )
                }

                Text(
                    text = "Your BMI Result",
                    style = MaterialTheme.typography.h5,
                    color = LocalContentColor.current,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                )
            }

        },
        content = {
            Content()
        }
    )
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        RoundedCard(modifier = Modifier.padding(4.dp)) {
            Row(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your BMI",
                    style = textStyle.copy(fontSize = 18.sp)
                )
                Text(
                    text = BMICalculator.bmiString,
                    style = textStyle.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 32.sp
                    )
                )
                Text(
                    text = BMICalculator.result,
                    style = textStyle.copy(
                        color = accentColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
            }
        }
        EmptyHeight2()
        val infoList = listOf(
            "Less than 18.5" to "Underweight",
            "18.5 to 24.9" to "Normal",
            "25 to 29.9" to "Overweight",
            "More than 29.9" to "Obesity"
        )
        RoundedCard(modifier = Modifier.padding(4.dp)) {
            Column {
                infoList.forEachIndexed { index, pair ->
                    InfoItemView(
                        info = pair,
                        hasDivider = index != infoList.lastIndex
                    )
                }
            }
        }
    }
}

@Composable
private fun InfoItemView(info: Pair<String, String>, hasDivider: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = info.first,
            modifier = Modifier.weight(1f),
            style = textStyle
        )
        Text(
            text = info.second,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End,
            style = textStyle.copy(fontWeight = FontWeight.Bold)
        )
    }
    if (hasDivider) {
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@Composable
fun EmptyHeight2() = Spacer(Modifier.height(32.dp))

@Preview
@Composable
private fun ScreenPreview() {
    AppTheme {
        InfoScreen(navController = rememberNavController())
    }
}
