package com.example.ahorcado

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ahorcado.viewModel.GameViewModel

@Composable
fun GameScreen(navController: NavController, myViewModel: GameViewModel){
    val audioWin=MediaPlayer.create(LocalContext.current,R.raw.win)
    var preguntas=when(myViewModel.dificultad){
        "Easy"->myViewModel.preguntasFaciles
        "Normal"-> myViewModel.preguntasNormales
        else->myViewModel.preguntasDificiles
    }
    Column(modifier = Modifier.padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.trivial),
            contentDescription = "ahorcado",
            modifier = Modifier.size(200.dp))
        Box(modifier = Modifier.clickable { navController.navigate(Routes.EndScreen.route) }){
            Text(text = myViewModel.dificultad,
                fontSize = 40.sp, letterSpacing = 5.sp)


        }
    }
}

