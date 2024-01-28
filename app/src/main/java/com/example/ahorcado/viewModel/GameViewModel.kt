package com.example.ahorcado.viewModel

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

@SuppressLint("MutableCollectionMutableState")
class GameViewModel:ViewModel() {
    //VARIABLES
    var puntuacion:Int by mutableIntStateOf(0)
        private set
    var dificultad:String by mutableStateOf("Easy")
        private set
    var duracion:Float by mutableFloatStateOf(5f)
        private set
    var rondas:Int by mutableIntStateOf(10)
        private set
    var statusUno by  mutableStateOf(false)
        private set
    var statusDos by  mutableStateOf(true)
        private set
    var statusTres by  mutableStateOf(false)
        private set
    var darkmode by  mutableStateOf(false)
        private set
    var preguntasFaciles by mutableStateOf(
        mutableListOf(
        "¿Cuál es la capital de Francia?",
        "¿Quién escribió el libro 'Don Quijote de la Mancha'?",
        "¿Cuál es el río más largo del mundo?",
        "¿Cuál es el color primario?",
        "¿Cuántos días tiene el mes de febrero en un año bisiesto?",
        "¿Cuál es el planeta más cercano al sol?",
        "¿Cuál es el animal terrestre más grande?",
        "¿Cuál es el océano más grande del mundo?",
        "¿Cuál es el resultado de sumar 2 + 2?",
        "¿Cuál es el idioma más hablado del mundo?",
        "¿En qué continente se encuentra Egipto?",
        "¿Cuál es el símbolo químico del oro?",
        "¿Cuál es el país más grande del mundo en términos de superficie?",
        "¿Cuál es el número atómico del oxígeno?",
        "¿Cuál es el autor de la obra 'Romeo y Julieta'?")
    )
        private set
    var preguntasNormales by mutableStateOf(mutableListOf(
        "¿Cuál es la capital de Australia?",
        "¿Quién pintó 'La última cena'?",
        "¿Cuál es el río más largo de América del Norte?",
        "¿Cuál es el color secundario obtenido al mezclar azul y amarillo?",
        "¿Cuántos días tiene el mes de abril?",
        "¿Cuál es el planeta más grande del sistema solar?",
        "¿Cuál es el animal marino más grande del mundo?",
        "¿Cuál es el segundo océano más grande del mundo?",
        "¿Cuál es el resultado de multiplicar 5 por 8?",
        "¿Cuál es el idioma oficial de Brasil?",
        "¿En qué año se firmó la Declaración de Independencia de Estados Unidos?",
        "¿Cuál es el símbolo químico del carbono?",
        "¿Cuál es la montaña más alta de Europa?",
        "¿Cuál es el número atómico del hierro?",
        "¿Cuál es el autor de la obra '1984'?"))
        private set
    var preguntasDificiles by mutableStateOf(mutableListOf(
        "¿Cuál es la capital de Mongolia?",
        "¿Quién escribió la obra 'Moby-Dick'?",
        "¿Cuál es el río más largo de América del Sur?",
        "¿Cuál es el color obtenido al mezclar azul, rojo y amarillo?",
        "¿Cuántos días tiene el mes de junio?",
        "¿Cuál es el planeta más pequeño del sistema solar?",
        "¿Cuál es el animal más rápido del mundo?",
        "¿Cuál es el océano más profundo del mundo?",
        "¿Cuál es el resultado de dividir 100 entre 7?",
        "¿Cuál es el idioma oficial de Japón?",
        "¿En qué año comenzó la Primera Guerra Mundial?",
        "¿Cuál es el símbolo químico del calcio?",
        "¿Cuál es la montaña más alta de África?",
        "¿Cuál es el número atómico del plomo?",
        "¿Cuál es el autor de la obra 'Cien años de soledad'?"))
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
        statusUno=true;statusDos=false;statusTres=false;rondas=5
    }
    fun modificarOpcionDos(){
        statusUno=false;statusDos=true;statusTres=false;rondas=10
    }
    fun modificarOpcionTres(){
        statusUno=false;statusDos=false;statusTres=true;rondas=15
    }
    fun switchDark(valor:Boolean){
        darkmode=valor
    }
}