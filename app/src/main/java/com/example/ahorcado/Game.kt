package com.example.ahorcado

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GameScreen(navController: NavController){
    var numImagen by remember { mutableIntStateOf(0) }
    var palabrasJuego by remember { mutableStateOf(arrayOf("pan","mandarina","croqueta","pepe","caballo","perry")) }
    val abc by remember { mutableStateOf(arrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z') )}
    var palabraRandom by remember {mutableIntStateOf((palabrasJuego.indices).random())}
    var palabraEscogida by remember {mutableStateOf("PEPE")} //palabrasJuego[palabraRandom]
    var palabraEscondida by remember { mutableStateOf("_".repeat(palabraEscogida.length))}
    var imagen = when(numImagen){
        0->R.drawable.fase0
        1->R.drawable.fase1
        2->R.drawable.fase2
        3->R.drawable.fase3
        4->R.drawable.fase4
        5->R.drawable.fase5
        else ->R.drawable.fase6
    }
    Image(painter = painterResource(id = R.drawable.beix),
        contentDescription = "Fondo",
        Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillBounds)
    Column(modifier = Modifier.padding(10.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imagen),
            contentDescription = "ahorcado",
            modifier = Modifier.size(200.dp))
        Box(modifier = Modifier){
            Text(text = palabraEscondida,
                fontSize = 40.sp, letterSpacing = 5.sp)
        }

        var inici =0
        var final =5
        var nuevaPalabraEscondida=palabraEscondida.toCharArray()
        var nuevaPalabraEscogida=palabraEscogida.uppercase().toCharArray()
        repeat(6){
            Row {
                for (i in inici..final){
                    var siOno=false
                    var letrita=abc[i]
                    var colorCasilla by remember { mutableStateOf(Color.White)}
                    Box(modifier = Modifier
                        .padding(3.dp)
                        .background(colorCasilla)
                        .width(50.dp)
                        .height(50.dp)
                        .border(width = 5.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                        .padding(4.dp)
                        .clickable {
                            for (letra in palabraEscogida.indices){
                                if (letrita==palabraEscogida[letra]){
                                    siOno=true
                                    nuevaPalabraEscondida[letra] = letrita
                                }
                            }
                            palabraEscondida=String(nuevaPalabraEscondida)
                            if (!siOno){
                                colorCasilla=Color.Red
                                numImagen++
                            }else{
                                colorCasilla=Color.Green
                            }
                        }){

                        Text(text = "$letrita",
                            modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
            inici=final+1
            if (final+5<abc.lastIndex){
                final+=6
            }else{
                final=abc.lastIndex
            }
        }
        if (palabraEscondida==palabraEscogida){
            navController.navigate(Routes.EndScreenGood.route)
        }
        if(imagen==R.drawable.fase6){
            navController.navigate(Routes.EndScreenBad.route)
        }
    }
}