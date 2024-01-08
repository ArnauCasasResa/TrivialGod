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


@Composable
fun EndScreen(){
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
            contentDescription = "IMC",
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier
            .height(20.dp)) {
        }
        Column(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier
                .background(Color.Gray)
                .width(125.dp)
                .padding(1.dp)
                .clickable {  }) {
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
        }

    }
}
