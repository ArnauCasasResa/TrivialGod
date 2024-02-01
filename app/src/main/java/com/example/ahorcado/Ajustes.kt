package com.example.ahorcado

import androidx.compose.foundation.Image
import com.example.ahorcado.Class.Routes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ahorcado.viewModel.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, myViewModel: GameViewModel){
    var expanded by remember { mutableStateOf(false) }
    val opciones = listOf("Easy", "Normal", "Dificult")

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(60.dp))
        Box(modifier =Modifier.height(50.dp)){
            Row {
                Text(text = "Difficulty", fontSize = 20.sp,
                    modifier = Modifier.padding(7.dp),
                    fontFamily = mario )
                Box{
                    OutlinedTextField(
                        value = myViewModel.dificultad,
                        onValueChange = { myViewModel.modificarDificultad(it) },
                        enabled = false,
                        readOnly = true,
                        modifier = Modifier
                            .clickable { expanded = true }
                            .width(125.dp)
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.width(125.dp)
                    ) {
                        opciones.forEach { option ->
                            DropdownMenuItem(text = { Text(text = option) },
                                modifier = Modifier
                                    .height(40.dp),
                                onClick = {
                                    expanded = false
                                    myViewModel.modificarDificultad(option)
                                })
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
        Box(modifier =Modifier.height(29.dp)){
            Row {
                Text(text = "Rounds",fontSize = 20.sp,
                    fontFamily = mario)
                RadioButton(selected = myViewModel.statusUno, onClick = { myViewModel.modificarRondas(5)
                    myViewModel.modificarOpcionUno() })
                Text(text = "5",fontSize = 20.sp)
                RadioButton(selected = myViewModel.statusDos, onClick = { myViewModel.modificarRondas(10)
                    myViewModel.modificarOpcionDos() })
                Text(text = "10",fontSize = 20.sp)
                RadioButton(selected = myViewModel.statusTres, onClick = { myViewModel.modificarRondas(15)
                    myViewModel.modificarOpcionTres() })
                Text(text = "15",fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
        Box{
            Row {
                Text(text = "Time per\n  round",fontSize = 20.sp,
                    fontFamily = mario)
                Column {
                    Slider(
                        value = myViewModel.duracion,
                        onValueChange = { myViewModel.modificarDuracion(it)},
                        valueRange = 10f..60f,
                        steps = 5,
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color(246, 205, 23),
                            inactiveTrackColor = Color.Black,
                            activeTickColor = Color(246, 205, 23),
                            inactiveTickColor = Color.Black
                        ),
                        thumb = {
                            Image(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = null,
                                Modifier.fillMaxSize(0.15f))
                        }
                    )
                    Text(text = "${ myViewModel.duracion.toInt()} s.",
                        modifier = Modifier.align(Alignment.CenterHorizontally))
                }
            }
        }

        Spacer(modifier = Modifier.height(80.dp))
        Box(modifier =Modifier.height(30.dp)){
            val on =if(myViewModel.darkmode)"ON"
                else "OFF"
            Row {
                Text(text = "Dark mode ",fontSize = 20.sp,
                    fontFamily = mario)
                Switch(checked = myViewModel.darkmode, onCheckedChange = {
                    if (!myViewModel.darkmode) {
                        myViewModel.switchDark(true)
                    }else {
                        myViewModel.switchDark(false)
                    }
                })
                Text(text =" $on" ,fontSize = 20.sp,
                    fontFamily = mario)
            }
        }
        Spacer(modifier = Modifier.height(200.dp))
        Box(modifier = Modifier
            .background(Color.Gray)
            .width(125.dp)
            .padding(1.dp)
            .align(Alignment.CenterHorizontally)
            .clickable { navController.navigate(Routes.MenuScreen.route) }) {
            Text(
                text = "Menu",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
    }
}

