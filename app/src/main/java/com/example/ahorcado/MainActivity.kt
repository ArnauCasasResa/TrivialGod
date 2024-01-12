package com.example.ahorcado

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ahorcado.ui.theme.AhorcadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AhorcadoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.SplashScreen.route
                    ) {
                        composable(Routes.SplashScreen.route) { SplashScreen(navigationController) }
                        composable(Routes.MenuScreen.route) { MenuScreen(navigationController) }
                        composable(Routes.GameScreen.route, arguments = listOf(navArgument("dificultad"){type= NavType.StringType}))
                            {backStackEntry -> GameScreen(navigationController,backStackEntry.arguments?.getString("dificultad")?:"dificil") }
                        composable(Routes.EndScreen.route,arguments = listOf(navArgument("win") {type = NavType.BoolType},
                            navArgument("tries"){type= NavType.IntType}))
                        {backStackEntry -> EndScreen(navigationController,
                            backStackEntry.arguments?.getBoolean("win") ?: false,
                            backStackEntry.arguments?.getInt("tries")?:0,
                            backStackEntry.arguments?.getString("dificultad")?:"dificil") }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AhorcadoTheme {
    }
}