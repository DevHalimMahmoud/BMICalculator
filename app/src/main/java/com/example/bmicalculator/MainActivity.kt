package com.example.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmicalculator.ui.screens.GenderScreen
import com.example.bmicalculator.ui.screens.InfoScreen
import com.example.bmicalculator.ui.screens.SplashScreen
import com.example.bmicalculator.ui.screens.WeightHeightScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash_screen") {

                composable("gender_screen") { GenderScreen(navController) }
                composable("splash_screen") { SplashScreen(navController) }
                composable("weight_height_screen") { WeightHeightScreen(navController) }
                composable("info_screen") { InfoScreen(navController) }
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
}