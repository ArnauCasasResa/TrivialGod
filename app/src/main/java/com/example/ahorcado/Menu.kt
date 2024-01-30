package com.example.ahorcado

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController){
    val titulo ="TRIVIAL"
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
            .height(100.dp)) {
        }
        Image(
            painter = painterResource(id = R.drawable.trivial),
            contentDescription = "AHORCADO",
            modifier = Modifier
                .fillMaxWidth()
                .size(300.dp)
        )
        Row {
            for (i in titulo.indices){
                Box(modifier = Modifier
                    .height(80.dp)) {
                    Text(text = titulo[i].toString(),
                        fontFamily = mario,
                        fontSize = 50.sp,
                        color = colorsTrivial[i])
                }
            }
        }

        Column(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable { navController.navigate(Routes.GameScreen.route) }) {
                Text(text = "Play",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White)
            }
            Box(modifier = Modifier
                .height(15.dp)) {
            }
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable {
                    navController.navigate(Routes.SettingsScreen.route)
                }) {
                Text(text = "Settings",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White)
            }
        }

    }
}

