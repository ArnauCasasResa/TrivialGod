package com.example.ahorcado

import android.annotation.SuppressLint
import com.example.ahorcado.Class.Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ahorcado.viewModel.GameViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController,myViewModel: GameViewModel){
    val titulo ="TRIVIAL"
    var tituloConstruccion by remember{ mutableStateOf("")}
    var timeLeft by remember { mutableStateOf(titulo.length)    }
    var longitudTitulo by remember{ mutableStateOf(titulo.length)}
    val colorsTrivial = listOf(
        Color.Red,
        Color.Green,
        Color.Yellow,
        Color.Blue,
        Color.Magenta,
        Color.Cyan,
        Color.Magenta
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier
            .height(100.dp))
        Image(
            painter = painterResource(id = R.drawable.trivial),
            contentDescription = "AHORCADO",
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
        )
        LaunchedEffect(key1 = titulo) {
            for (i in titulo.indices){
                delay(1000L)
                tituloConstruccion+=titulo[i]

            }
        }
        Row {
            Box{
                Text(text = tituloConstruccion,
                    fontFamily = marioTitulos,
                    fontSize = 60.sp)
            }
        }

        Column(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable { navController.navigate(Routes.GameScreen.route);myViewModel.rebootPuntuacio() }) {
                Text(text = "Play",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontFamily = mario)
            }
            Box(modifier = Modifier
                .height(15.dp))
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable {
                    navController.navigate(Routes.SettingsScreen.route)
                }) {
                Text(text = "Settings",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontFamily = mario)
            }
        }

    }
}