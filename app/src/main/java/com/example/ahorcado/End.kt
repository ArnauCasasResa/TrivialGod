package com.example.ahorcado

import android.content.Intent
import com.example.ahorcado.Class.Routes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
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
            contentDescription = "Trivial",
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
                text = "Your Score",
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center),
                fontFamily = marioTitulos
            )
            }
            Box(modifier = Modifier
                .padding(2.dp)
                .align(Alignment.CenterHorizontally)) {
                Text(
                    text = "${myViewModel.puntuacion} pts.",
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center),
                    fontFamily = mario
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier.align(Alignment.CenterHorizontally)){
                Share("Tu puntuacion es de ${myViewModel.puntuacion}/${myViewModel.rondas}")
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
                    color = Color.White,
                    fontFamily = mario
                )
            }
        }

    }
}

@Composable
fun Share(texto:String){
    val context = LocalContext.current
    val sendIntent= Intent( Intent.ACTION_SEND).apply{
        type = "text/plain"
        putExtra(Intent. EXTRA_TEXT, texto)
    }
    val shareIntent=Intent.createChooser( sendIntent ,"Share with... " )
    Box(modifier = Modifier
        .background(Color.Gray)
        .width(125.dp)
        .padding(1.dp)
        .clickable { startActivity(context, shareIntent, null) }) {
        Text(
            text = "Share",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontFamily = mario
        )
    }
}