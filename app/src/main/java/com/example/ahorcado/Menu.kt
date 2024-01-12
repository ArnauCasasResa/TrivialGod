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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController){
    var selectedText by remember { mutableStateOf("Easy") }
    var expanded by remember { mutableStateOf(false) }
    val hobbies = listOf("Easy", "Normal", "Dificult")
    var show by remember { mutableStateOf(false) }
    Image(painter = painterResource(id = R.drawable.beix),
        contentDescription = "Fondo",
        Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillBounds)
    Column(modifier = Modifier.padding(20.dp),horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier
            .height(100.dp)) {
        }
        Image(
            painter = painterResource(id = R.drawable.ahorcado),
            contentDescription = "AHORCADO",
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier
            .height(20.dp)) {
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier
                .height(15.dp)) {
            }
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable { navController.navigate(Routes.GameScreen.createRoute(selectedText)) }) {
                Text(text = "Play",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White)
            }
            Box(modifier = Modifier
                .height(15.dp)) {
            }
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable {
                    show = true
                }) {
                Text(text = "Help",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White)
                MyDialog(show,{ show = false })
            }
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .width(125.dp).background(color = Color.LightGray)
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(125.dp)
            ) {
                hobbies.forEach { hobby ->
                    DropdownMenuItem(text = { Text(text = hobby) },
                        modifier = Modifier.background(color=Color.LightGray),
                        onClick = {
                            expanded = false
                            selectedText = hobby
                        })
                }
            }
        }

    }
}

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit){
    if(show){
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()) {
                Text(text = "Como se juega?")
                Text(text = "\nEl objetivo del juego es adivinar la palabra con la unica pista que nos dan que es la cantidad de letras que contiene.")
                Text(text = "Al elegir una letra, si en esa palabra esta la letra que hsa escogido se revelara la posicion y la cantidad(si esque esa letra esta repetida), posteriormente se descartara la letra")
                Text(text = "Si no esta en la palabra se descartara la letra y se iniciara el dibujo del ahorcado, si el dibujo se completa y no consigue completar la palabra habras perdido.")

            }
        }
    }
}

