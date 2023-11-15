package com.example.sumadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.sumadora.ui.theme.SumadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumadoraApp()
        }
    }
}

@Composable
fun SumadoraApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Input.route
    ) {
        composable(Screen.Input.route) {
            InputScreen(navController = navController, viewModel = viewModel) { result ->
                navController.navigate(Screen.Result.withArgs(result))
            }
        }
        composable(Screen.Result.route) { backStackEntry ->
            val result = requireNotNull(backStackEntry.arguments?.getString(Screen.Result.ARG_RESULT))
            Resultados(navController = navController, viewModel = viewModel, result = result) {
                navController.navigate(Screen.Input.route)
            }
        }
    }
}
