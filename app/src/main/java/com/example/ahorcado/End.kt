package com.example.ahorcado

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ahorcado.viewModel.GameViewModel


@Composable
fun EndScreen(navController: NavController, myViewModel: GameViewModel){
    Column(modifier = Modifier.padding(20.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .height(100.dp)
        ) {
        }
        Image(
            painter = painterResource(id = R.drawable.trivial),
            contentDescription = "Ahogado",
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .height(20.dp)
        ) {
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier.padding(2.dp)) {
            Text(
                text = "Has perdido :(, quieres jugar otra vez?",
                modifier = Modifier.align(Alignment.Center)
            )


            Text(text = "Has ganado :) , quieres jugar otra vez?")

            Text(text = "Has ganado :) con pan fallos, quieres jugar otra vez?")


            }
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { navController.navigate(Routes.MenuScreen.route) }) {
                Text(
                    text = "Share",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .height(15.dp)
            ) {
            }
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .align(Alignment.CenterHorizontally)
                .clickable { navController.navigate(Routes.MenuScreen.route) }) {
                Text(
                    text = "Return to menu",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }
        }

    }
}
