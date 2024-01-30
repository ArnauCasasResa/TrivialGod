package com.example.ahorcado

import com.example.ahorcado.Class.Routes
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ahorcado.ui.theme.AhorcadoTheme
import com.example.ahorcado.viewModel.GameViewModel
val mario = FontFamily(Font(R.font.mariobros)  )
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel by viewModels<GameViewModel>()
        setContent {
            AhorcadoTheme(myViewModel.darkmode) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.MenuScreen.route
                    ) {
                        composable(Routes.MenuScreen.route) { MenuScreen(navigationController) }
                        composable(Routes.SettingsScreen.route) { SettingsScreen(navigationController,myViewModel)}
                        composable(Routes.GameScreen.route) {GameScreen(navigationController,myViewModel) }
                        composable(Routes.EndScreen.route) {EndScreen(navigationController,myViewModel)}
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