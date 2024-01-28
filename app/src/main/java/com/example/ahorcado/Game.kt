package com.example.ahorcado

import android.graphics.drawable.shapes.Shape
import com.example.ahorcado.Class.Routes
import android.media.MediaPlayer
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
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
    var preguntaActual by remember { mutableStateOf(preguntas.random()) }
    var rondaActual by remember { mutableIntStateOf(1) }
    Column(modifier = Modifier.padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "$rondaActual/${ myViewModel.rondas }")
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.clickable {  }){
            Text(text = preguntaActual,
                fontSize = 20.sp,
                textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(R.drawable.question), contentDescription ="pregunta" )
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Box(modifier = Modifier
                .clickable{
                    if (rondaActual==myViewModel.rondas){
                        navController.navigate(Routes.EndScreen.route)
                    }else {
                        preguntas.remove(preguntaActual)
                        preguntaActual=preguntas.random()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = "pepe")

            }
            Spacer(modifier = Modifier.width(100.dp))
            Box(modifier = Modifier
                .clickable{
                    if (rondaActual==myViewModel.rondas){
                        navController.navigate(Routes.EndScreen.route)
                    }else {
                        preguntas.remove(preguntaActual)
                        preguntaActual=preguntas.random()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = "pepe")

            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Box(modifier = Modifier
                .clickable{
                    if (rondaActual==myViewModel.rondas){
                        navController.navigate(Routes.EndScreen.route)
                    }else {
                        preguntas.remove(preguntaActual)
                        preguntaActual=preguntas.random()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = "pepe")

            }
            Spacer(modifier = Modifier.width(100.dp))
            Box(modifier = Modifier
                .clickable{
                    if (rondaActual==myViewModel.rondas){
                        navController.navigate(Routes.EndScreen.route)
                    }else {
                        preguntas.remove(preguntaActual)
                        preguntaActual=preguntas.random()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = "pepe")

            }

        }
    }

}

