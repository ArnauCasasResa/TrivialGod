package com.example.ahorcado.viewModel

import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel:ViewModel() {
    //VARIABLES
    var dificultad:String by mutableStateOf("Easy")
        private set
    var duracion:Float by mutableStateOf(5f)
        private set
    var rondas:Int by mutableStateOf(10)
        private set
    var statusUno by  mutableStateOf(false)
        private set
    var statusDos by  mutableStateOf(true)
        private set
    var statusTres by  mutableStateOf(false)
        private set
    var darkmode by  mutableStateOf(false)
        private set


    //MODIFICACIONES DE VARIABLES
    fun modificarDificultad(valor:String){
        dificultad=valor
    }
    fun modificarDuracion(valor:Float){
        duracion=valor
    }
    fun modificarRondas(valor:Int){
        rondas=valor
    }
    fun modificarOpcionUno(){
        statusUno=true;statusDos=false;statusTres=false
    }
    fun modificarOpcionDos(){
        statusUno=false;statusDos=true;statusTres=false
    }
    fun modificarOpcionTres(){
        statusUno=false;statusDos=false;statusTres=true
    }
    fun switchDark(valor:Boolean){
        darkmode=valor
    }
}