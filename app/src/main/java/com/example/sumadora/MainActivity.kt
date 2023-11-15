import android.os.Bundle
import com.example.sumadora.SumadoraScreen
import com.example.sumadora.Screen
import androidx.navigation.NavHost
import com.example.sumadora.InputScreen
import com.example.sumadora.Resultados
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sumadoraScreen: SumadoraScreen = viewModel()
        setContent {
            SumadoraApp(viewModel = sumadoraScreen)
        }
    }
}

@Composable
fun SumadoraApp(viewModel: SumadoraScreen) {
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
        composable(Screen.Result.route) {backStackEntry ->
            val result = requireNotNull(backStackEntry.arguments?.getString(Screen.Result.ARG_RESULT))
            Resultados(navController = navController, viewModel = viewModel, result = result) {
                navController.navigate(Screen.Input.route)
            }
        }
    }
}


