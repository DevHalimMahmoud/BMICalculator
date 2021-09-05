package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.util.BMICalculator


@Composable
fun GenderScreen(navController: NavController) {
    /*...*/
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        topBar = {
            Text(
                text = "Choose One",
                style = MaterialTheme.typography.h4,
                color = LocalContentColor.current,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),

                )
        },
        content = {
            GenderScreenContent(navController)


        }
    )
}


@Composable
fun GenderScreenContent(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(0.dp, 80.dp, 0.dp, 8.dp),


            ) {


            Image(
                painter = painterResource(id = com.example.bmicalculator.R.drawable.male),
                contentDescription = "man image", // decorative element
                Modifier
                    .height(250.dp)
                    .width(150.dp)
                    .weight(0.5F),

                )
            Image(
                painter = painterResource(id = com.example.bmicalculator.R.drawable.female),
                contentDescription = "women image" // decorative element
                ,
                Modifier
                    .height(250.dp)
                    .width(150.dp)
                    .weight(0.5F)

            )

        }
        Row(
            modifier = Modifier.wrapContentSize(),

            ) {


        }
        Row(
            modifier = Modifier.wrapContentSize(),

            ) {


            Button(
                border = BorderStroke(1.dp, Color(0xFF54c7f5)),
                shape = RoundedCornerShape(50), // = 50% percent
                //or shape = CircleShape
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF54c7f5)),
                onClick = { navController.navigate("weight_height_screen") },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp)

            ) {

                Text(text = "Male")
            }
            Button(
                border = BorderStroke(1.dp, Color(0xFFe53671)),
                shape = RoundedCornerShape(50), // = 50% percent
                //or shape = CircleShape
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFe53671)),
                onClick = {
                    navController.navigate("weight_height_screen")
                    BMICalculator.gender = "female"
                },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(8.dp),


                ) {

                Text(text = "Female")

            }


        }

        Row {
            Text(
                text = "BMI Centile is sex specific. For both children and adults, we give more personalised information based on whether you are male or female.",
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .semantics { heading() },

                )


        }

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GenderScreen(navController = rememberNavController())
}