package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.ui.theme.AppTheme
import com.example.bmicalculator.ui.widgets.RoundIconButton
import com.example.bmicalculator.ui.widgets.RoundedCard
import com.example.bmicalculator.ui.widgets.textStyle
import com.example.bmicalculator.util.BMICalculator


@Composable
fun WeightHeightScreen(navController: NavController) {


    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),


        topBar = {
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically


            ) {
                IconButton(
                    onClick = {
                        navController.navigate("gender_screen") {
                            popUpTo("weight_height_screen") {
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
                    text = "Your height & weight",
                    style = MaterialTheme.typography.h5,
                    color = LocalContentColor.current,
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)


                )
            }


        },
        content = {
            WeightHeightScreenContent(navController)

        }
    )
}


@Composable
private fun WeightHeightScreenContent(navController: NavController) {
    Column(

        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        val heightState = remember { mutableStateOf(BMICalculator.height) }
        val weightState: MutableState<Int> = remember { mutableStateOf(BMICalculator.weight) }
        val ageState: MutableState<Int> = remember { mutableStateOf(BMICalculator.age) }
        PickerView(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(top = 16.dp),
            heightState = heightState,
            weightState = weightState,
            ageState = ageState
        )

        Card(
            modifier = Modifier
                .padding(all = 16.dp)
                .clickable(onClick = {})
                .size(70.dp)
                .align(Alignment.CenterHorizontally)
                .clickable(onClick = {
                    BMICalculator.weight = weightState.value
                    BMICalculator.height = heightState.value
                    BMICalculator.age = ageState.value
                    BMICalculator.CalculateBMI()
                    navController.navigate("info_screen")

                }),

            backgroundColor = Color(0xFFe53671),

            shape = CircleShape

        ) {
            Icon(
                Icons.Filled.ArrowForward,
                contentDescription = "Next Button",
                tint = Color.White,
                modifier = Modifier.padding(8.dp)

            )
        }

    }
}

@Composable
private fun PickerView(
    modifier: Modifier = Modifier,
    heightState: MutableState<Int>,
    weightState: MutableState<Int>,
    ageState: MutableState<Int>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HeightSelector(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
                .fillMaxHeight(),
            heightState = heightState
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberPicker(
                label = "Weight",
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
                    .fillMaxHeight(),
                pickerState = weightState
            )
            NumberPicker(
                label = "Age",
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .fillMaxHeight(),
                pickerState = ageState
            )
        }
    }
}

@Composable
private fun HeightSelector(
    modifier: Modifier = Modifier,
    heightState: MutableState<Int>
) {
    val height = buildAnnotatedString {
        withStyle(
            style = SpanStyle(fontSize = 32.sp)
        ) { append(heightState.value.toString()) }
        append(" cm")
    }
    RoundedCard(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            //.gravity(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Height",
                modifier = ColumnChildModifier,
                style = LabelStyle
            )
            Slider(
                value = heightState.value.toFloat(),
                onValueChange = { heightState.value = it.toInt() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                valueRange = (1f..272f),
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFFe53671),
                    thumbColor = Color.Black
                )
            )
            Text(
                text = height,
                modifier = ColumnChildModifier,
                style = textStyle
            )
        }
    }
}

@Composable
private fun NumberPicker(
    label: String,
    modifier: Modifier = Modifier,
    pickerState: MutableState<Int>,
    range: IntRange = 1..100
) {
    RoundedCard(modifier = modifier) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                style = LabelStyle,
                modifier = ColumnChildModifier
            )
            Text(
                text = pickerState.value.toString(),
                style = ValueStyle,
                modifier = ColumnChildModifier
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = ColumnChildModifier.fillMaxWidth()
            ) {
                RoundIconButton(imageVector = Icons.Default.Add, onClick = {
                    if (pickerState.value < range.last) {
                        pickerState.value = pickerState.value + 1
                    }
                })
                RoundIconButton(imageVector = Icons.Default.Remove, onClick = {
                    if (pickerState.value > range.first) {
                        pickerState.value = pickerState.value - 1
                    }
                })
            }
        }
    }
}


@Preview
@Composable
private fun ScreenPreview() {
    AppTheme {
        WeightHeightScreen(navController = rememberNavController())
    }
}

private val LabelStyle = TextStyle(
    color = Color.Black.copy(alpha = 0.6f),
    fontSize = 18.sp
)

private val ValueStyle = TextStyle(
    color = Color.Black.copy(alpha = 0.9f),
    fontSize = 32.sp
)

private val ColumnChildModifier = Modifier.padding(8.dp)


