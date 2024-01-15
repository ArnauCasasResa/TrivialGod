package com.example.ahorcado

import android.widget.RadioButton
import android.widget.Switch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController){
    var tiempo by remember { mutableFloatStateOf(5f) }
    var oscuro by remember { mutableStateOf(false) }
    var statusUno by remember { mutableStateOf(false) }
    var statusDos by remember { mutableStateOf(true) }
    var statusTres by remember { mutableStateOf(false) }
    var rondas by remember { mutableStateOf("10")}
    var dificultad by remember { mutableStateOf("Easy") }
    var expanded by remember { mutableStateOf(false) }
    val opciones = listOf("Easy", "Normal", "Dificult")

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(60.dp))
        Box(modifier =Modifier.height(50.dp)){
            Row {
                Text(text = "Difficulty", fontSize = 20.sp, modifier = Modifier.padding(7.dp) )
                OutlinedTextField(
                    value = dificultad,
                    onValueChange = { dificultad = it },
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .width(125.dp)
                        .background(color = Color.LightGray)
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(125.dp)
                ) {
                    opciones.forEach { option ->
                        DropdownMenuItem(text = { Text(text = option) },
                            modifier = Modifier
                                .background(color = Color.LightGray)
                                .height(40.dp),
                            onClick = {
                                expanded = false
                                dificultad = option
                            })
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
        Box(modifier =Modifier.height(29.dp)){
            Row {
                Text(text = "Rounds",fontSize = 20.sp)
                RadioButton(selected = statusUno, onClick = { rondas = "5";statusUno=true;statusDos=false;statusTres=false })
                Text(text = "5",fontSize = 20.sp)
                RadioButton(selected = statusDos, onClick = { rondas = "10";statusDos=true;statusUno=false;statusTres=false })
                Text(text = "10",fontSize = 20.sp)
                RadioButton(selected = statusTres, onClick = { rondas = "15";statusTres=true;statusUno=false;statusDos=false })
                Text(text = "15",fontSize = 20.sp)
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
        Box(){
            Row {
                Text(text = "Time per\n  round",fontSize = 20.sp)
                Slider(
                    value = tiempo,
                    onValueChange = { tiempo = it },
                    valueRange = 0f..10f,
                    steps = 9
                )
            }

        }

        Spacer(modifier = Modifier.height(80.dp))
        Box(modifier =Modifier.height(30.dp)){
            val on =if(oscuro)"ON"
                else "OFF"
            Row {
                Text(text = "Dark mode ",fontSize = 20.sp)
                Switch(checked = oscuro, onCheckedChange = { oscuro = !oscuro })
                Text(text =" $on" ,fontSize = 20.sp)
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

