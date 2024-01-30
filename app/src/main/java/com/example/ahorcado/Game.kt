package com.example.ahorcado

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
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
import kotlinx.coroutines.delay
import java.sql.Time

@SuppressLint("MutableCollectionMutableState")
@Composable
fun GameScreen(navController: NavController, myViewModel: GameViewModel){
    val audioWin=MediaPlayer.create(LocalContext.current,R.raw.win)
    var preguntas=when(myViewModel.dificultad){
        "Easy"->myViewModel.preguntasFaciles
        "Normal"-> myViewModel.preguntasNormales
        else->myViewModel.preguntasDificiles
    }
    var tiempo by remember { mutableStateOf(myViewModel.duracion)}
    var preguntaActual by remember { mutableStateOf(preguntas.random()) }
    var rondaActual by remember { mutableIntStateOf(1) }
    var respostes by remember{ mutableStateOf(preguntaActual.answers.shuffled())}
    var respuestaUno=respostes[0]
    var respuestaDos=respostes[1]
    var respuestaTres=respostes[2]
    var respuestaQuatro=respostes[3]
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "$rondaActual/${ myViewModel.rondas }")
        Spacer(modifier = Modifier.height(20.dp))
        Box{
            Text(text = preguntaActual.question,
                fontSize = 20.sp,
                textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(R.drawable.question), contentDescription ="pregunta" )
        Spacer(modifier = Modifier.height(50.dp))
        Row (Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .size(150.dp)
                .clickable {
                    if (rondaActual == myViewModel.rondas) {
                        navController.navigate(Routes.EndScreen.route)
                    } else {
                        if (respuestaUno==preguntaActual.correctAnswer){
                            myViewModel.aumentarPuntuacion()
                        }

                        preguntas.remove(preguntaActual)
                        preguntaActual = preguntas.random()
                        respostes=preguntaActual.answers.shuffled()
                        rondaActual++
                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = respuestaUno,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp)

            }
            Spacer(modifier = Modifier.width(70.dp))
            Box(modifier = Modifier
                .size(150.dp)
                .clickable {
                    if (rondaActual == myViewModel.rondas) {
                        navController.navigate(Routes.EndScreen.route)
                    } else {
                        if (respuestaDos==preguntaActual.correctAnswer){
                            myViewModel.aumentarPuntuacion()
                        }
                        preguntas.remove(preguntaActual)
                        preguntaActual = preguntas.random()
                        respostes=preguntaActual.answers.shuffled()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = respuestaDos,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp)

            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row (Modifier.fillMaxWidth()){
            Box(modifier = Modifier
                .size(150.dp)
                .clickable {
                    if (rondaActual == myViewModel.rondas) {
                        navController.navigate(Routes.EndScreen.route)
                    } else {
                        if (respuestaTres==preguntaActual.correctAnswer){
                            myViewModel.aumentarPuntuacion()
                        }
                        preguntas.remove(preguntaActual)
                        preguntaActual = preguntas.random()
                        respostes=preguntaActual.answers.shuffled()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = respuestaTres,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp)

            }
            Spacer(modifier = Modifier.width(70.dp))
            Box(modifier = Modifier
                .size(150.dp)
                .clickable {
                    if (rondaActual == myViewModel.rondas) {
                        navController.navigate(Routes.EndScreen.route)
                    } else {
                        if (respuestaQuatro==preguntaActual.correctAnswer){
                            myViewModel.aumentarPuntuacion()
                        }
                        preguntas.remove(preguntaActual)
                        preguntaActual = preguntas.random()
                        respostes=preguntaActual.answers.shuffled()
                        rondaActual++

                    }
                }
                .clip(shape = RoundedCornerShape(6.dp))
                .border(BorderStroke(4.dp, Color.Blue))
                .padding(20.dp)
            ){
                Text(text = respuestaQuatro,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center),
                    fontSize = 20.sp)

            }

        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()){
                LinearProgressIndicator(progress = tiempo)
            }
            Text(text = "${tiempo.toInt()}")
        }

    }

}

