package com.example.ahorcado

import android.annotation.SuppressLint
import android.content.res.Configuration
import com.example.ahorcado.Class.Routes
import android.media.MediaPlayer
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ahorcado.viewModel.GameViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.sql.Time

@SuppressLint("MutableCollectionMutableState", "CoroutineCreationDuringComposition")
@Composable
fun GameScreen(navController: NavController, myViewModel: GameViewModel){
    val audioWin=MediaPlayer.create(LocalContext.current,R.raw.win)
    var colorCasillaUno by remember{ mutableStateOf(Color.Transparent)}
    var colorCasillaDos by remember{ mutableStateOf(Color.Transparent)}
    var colorCasillaTres by remember{ mutableStateOf(Color.Transparent)}
    var colorCasillaQuatro by remember{ mutableStateOf(Color.Transparent)}

    var preguntas=when(myViewModel.dificultad){
        "Easy"->myViewModel.preguntasFaciles
        "Normal"-> myViewModel.preguntasNormales
        else->myViewModel.preguntasDificiles
    }
    var tiempo by rememberSaveable { mutableStateOf(myViewModel.duracion)}
    var botonHabilitado by remember{mutableStateOf(true)}
    var preguntaActual by remember { mutableStateOf(preguntas.random()) }
    var rondaActual by remember { mutableIntStateOf(1) }
    var respostes by remember{ mutableStateOf(preguntaActual.answers.shuffled())}
    var respuestaUno=respostes[0]
    var respuestaDos=respostes[1]
    var respuestaTres=respostes[2]
    var respuestaQuatro=respostes[3]

    val configuration= LocalConfiguration.current

    if(!(configuration.orientation== Configuration.ORIENTATION_LANDSCAPE)) {


        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "$rondaActual/${myViewModel.rondas}",
                fontFamily = mario
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box {
                Text(
                    text = preguntaActual.question,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = marioTitulos
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Image(painter = painterResource(R.drawable.question), contentDescription = "pregunta")
            Spacer(modifier = Modifier.height(50.dp))
            Row(Modifier.fillMaxWidth()) {
                Box(modifier = Modifier
                    .size(150.dp)
                    .background(colorCasillaUno)
                    .clickable(enabled = botonHabilitado) {

                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaUno == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaUno = Color.Green
                            } else {
                                colorCasillaUno = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaUno = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                            preguntas.remove(preguntaActual)
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaUno,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }
                Spacer(modifier = Modifier.width(70.dp))
                Box(modifier = Modifier
                    .size(150.dp)
                    .background(colorCasillaDos)
                    .clickable(enabled = botonHabilitado) {
                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaDos == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaDos = Color.Green
                            } else {
                                colorCasillaDos = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntas.remove(preguntaActual)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaDos = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaDos,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(Modifier.fillMaxWidth()) {
                Box(modifier = Modifier
                    .size(150.dp)
                    .background(colorCasillaTres)
                    .clickable(enabled = botonHabilitado) {
                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaTres == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaTres = Color.Green
                            } else {
                                colorCasillaTres = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntas.remove(preguntaActual)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaTres = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaTres,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }
                Spacer(modifier = Modifier.width(70.dp))
                Box(modifier = Modifier
                    .size(150.dp)
                    .background(colorCasillaQuatro)
                    .clickable(enabled = botonHabilitado) {
                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaQuatro == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaQuatro = Color.Green
                            } else {
                                colorCasillaQuatro = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntas.remove(preguntaActual)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaQuatro = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaQuatro,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }

            }
            LaunchedEffect(tiempo) {
                while (tiempo > 0) {
                    delay(1000L)
                    if (botonHabilitado) {
                        tiempo--
                    }
                }
            }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Time left: ${tiempo.toInt()}",
                    fontFamily = mario
                )
                LinearProgressIndicator(progress = tiempo / myViewModel.duracion)
            }
            if (tiempo == 0f) {
                preguntas.remove(preguntaActual)
                preguntaActual = preguntas.random()
                respostes = preguntaActual.answers.shuffled()
                rondaActual++
                tiempo = myViewModel.duracion
            }
        }
    }else{
        //HORIZONTAL----------------------------------------------------------------------------------------
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "$rondaActual/${myViewModel.rondas}",
                fontFamily = mario,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box {
                Text(
                    text = preguntaActual.question,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = marioTitulos
                )
            }


            Spacer(modifier = Modifier.height(40.dp))
            Row(Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)) {
                Spacer(modifier = Modifier.width(60.dp))
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(colorCasillaUno)
                    .clickable(enabled = botonHabilitado) {

                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaUno == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaUno = Color.Green
                            } else {
                                colorCasillaUno = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaUno = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                            preguntas.remove(preguntaActual)
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaUno,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }
                Spacer(modifier = Modifier.width(50.dp))
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(colorCasillaDos)
                    .clickable(enabled = botonHabilitado) {
                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaDos == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaDos = Color.Green
                            } else {
                                colorCasillaDos = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntas.remove(preguntaActual)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaDos = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaDos,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }


            Spacer(modifier = Modifier.height(20.dp))
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(colorCasillaTres)
                    .clickable(enabled = botonHabilitado) {
                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaTres == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaTres = Color.Green
                            } else {
                                colorCasillaTres = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntas.remove(preguntaActual)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaTres = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaTres,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }
                Spacer(modifier = Modifier.width(50.dp))
                Box(modifier = Modifier
                    .size(100.dp)
                    .background(colorCasillaQuatro)
                    .clickable(enabled = botonHabilitado) {
                        if (rondaActual == myViewModel.rondas) {
                            navController.navigate(Routes.EndScreen.route)
                            audioWin.start()
                        } else {
                            if (respuestaQuatro == preguntaActual.correctAnswer) {
                                myViewModel.aumentarPuntuacion()
                                colorCasillaQuatro = Color.Green
                            } else {
                                colorCasillaQuatro = Color.Red
                            }
                            botonHabilitado = false
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)
                                preguntas.remove(preguntaActual)
                                preguntaActual = preguntas.random()
                                respostes = preguntaActual.answers.shuffled()
                                rondaActual++
                                colorCasillaQuatro = Color.Transparent
                                botonHabilitado = true
                                tiempo = myViewModel.duracion
                            }
                        }
                    }
                    .clip(shape = RoundedCornerShape(6.dp))
                    .border(BorderStroke(4.dp, Color.Blue))
                    .padding(20.dp)
                ) {
                    Text(
                        text = respuestaQuatro,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.Center),
                        fontSize = 20.sp,
                        fontFamily = mario
                    )

                }

            }
            LaunchedEffect(tiempo) {
                while (tiempo > 0) {
                    delay(1000L)
                    if (botonHabilitado) {
                        tiempo--
                    }
                }
            }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Time left: ${tiempo.toInt()}",
                    fontFamily = mario
                )
                LinearProgressIndicator(progress = tiempo / myViewModel.duracion)
            }
            if (tiempo == 0f) {
                preguntas.remove(preguntaActual)
                preguntaActual = preguntas.random()
                respostes = preguntaActual.answers.shuffled()
                rondaActual++
                tiempo = myViewModel.duracion
            }
        }
    }
}