package com.example.ahorcado

import android.widget.RadioButton
import android.widget.Switch
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController){
    var state by remember { mutableStateOf(false) }
    var statusUno by remember { mutableStateOf(false) }
    var statusDos by remember { mutableStateOf(true) }
    var statusTres by remember { mutableStateOf(false) }
    var rondas ="10"
        if (statusUno){
            rondas="5"
        }else if (statusDos){
            rondas="10"
        }else if (statusTres){
            rondas="15"
        }
    var dificultad by remember { mutableStateOf("Easy") }
    var expanded by remember { mutableStateOf(false) }
    val opciones = listOf("Easy", "Normal", "Dificult")
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Box(){
            Row {
                Text(text = "Difficulty")
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
                            modifier = Modifier.background(color = Color.LightGray),
                            onClick = {
                                expanded = false
                                dificultad = option
                            })
                    }
                }
            }
        }
        Box{
            Row {
                Text(text = "Rounds")
                Text(text = "5")
                RadioButton(selected = statusUno, onClick = { rondas = "5";statusUno=true;statusDos=false;statusTres=false })
                Text(text = "10")
                RadioButton(selected = statusDos, onClick = { rondas = "10";statusDos=true;statusUno=false;statusTres=false })
                Text(text = "15")
                RadioButton(selected = statusTres, onClick = { rondas = "15";statusTres=true;statusUno=false;statusDos=false })
            }
        }
        Box(){
            Row {
                Text(text = "Time per round")
            }
        }
        Box(){
            Row {
                Text(text = "Dark mode")
                Switch(checked = state, onCheckedChange = { state = !state })
            }
        }
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