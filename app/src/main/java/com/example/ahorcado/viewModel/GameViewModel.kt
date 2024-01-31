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
import com.example.ahorcado.Class.Preguntas
import com.example.ahorcado.R

@SuppressLint("MutableCollectionMutableState")
class GameViewModel:ViewModel() {
    //VARIABLES
    var puntuacion:Int by mutableIntStateOf(0)
        private set
    var dificultad:String by mutableStateOf("Easy")
        private set
    var duracion:Float by mutableFloatStateOf(30f)
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
    var fondo =if (!darkmode){ R.drawable.blanco }else R.drawable.negro
    var preguntasFaciles by mutableStateOf(
        mutableListOf(
            Preguntas.quiz(
                "¿Cual es la capital de Francia?",
                mutableListOf("Madrid", "Roma", "Paris", "Berlin"),
                "Paris"
            ),
            Preguntas.quiz(
                "¿Quien escribio el libro 'Don Quijote de la Mancha'?",
                mutableListOf("Miguel de Cervantes", "Gabriel Garcia Marquez", "William Shakespeare", "Leo Tolstoy"),
                "Miguel de Cervantes"
            ),
            Preguntas.quiz(
                "¿Cual es el rio mas largo del mundo?",
                mutableListOf("Nilo", "Amazonas", "Mississippi", "Yangtse"),
                "Amazonas"
            ),
            Preguntas.quiz(
                "¿Cual es el color primario?",
                mutableListOf("Rojo", "Verde", "Azul", "Amarillo"),
                "Rojo"
            ),
            Preguntas.quiz(
                "¿Cuantos dias tiene el mes de febrero en un año bisiesto?",
                mutableListOf("28", "29", "30", "31"),
                "29"
            ),
            Preguntas.quiz(
                "¿Cual es el planeta mas cercano al sol?",
                mutableListOf("Tierra", "Marte", "Mercurio", "Jupiter"),
                "Mercurio"
            ),
            Preguntas.quiz(
                "¿Cual es el animal terrestre mas grande?",
                mutableListOf("Elefante", "Jirafa", "Ballena Azul", "Hipopotamo"),
                "Elefante"
            ),
            Preguntas.quiz(
                "¿Cual es el oceano mas grande del mundo?",
                mutableListOf("Oceano Atlantico", "Oceano Indico", "Oceano Pacifico", "Oceano Artico"),
                "Oceano Pacifico"
            ),
            Preguntas.quiz(
                "¿Cual es el resultado de sumar 2 + 2?",
                mutableListOf("3", "4", "5", "6"),
                "4"
            ),
            Preguntas.quiz(
                "¿Cual es el idioma mas hablado del mundo?",
                mutableListOf("Ingles", "Chino mandarin", "Espanol", "Hindi"),
                "Ingles"
            ),
            Preguntas.quiz(
                "¿En que continente se encuentra Egipto?",
                mutableListOf("Europa", "Asia", "Africa", "Oceania"),
                "Africa"
            ),
            Preguntas.quiz(
                "¿Cual es el simbolo quimico del oro?",
                mutableListOf("Au", "Ag", "Fe", "Cu"),
                "Au"
            ),
            Preguntas.quiz(
                "¿Cual es el pais mas grande del mundo en terminos de superficie?",
                mutableListOf("Rusia", "China", "Estados Unidos", "Canada"),
                "Rusia"
            ),
            Preguntas.quiz(
                "¿Cual es el numero atomico del oxigeno?",
                mutableListOf("6", "7", "8", "9"),
                "8"
            ),
            Preguntas.quiz(
                "¿Cual es el autor de la obra 'Romeo y Julieta'?",
                mutableListOf("William Shakespeare", "Jorge Luis Borges", "Gabriel Garcia Marquez", "Miguel de Cervantes"),
                "William Shakespeare"
            )
        )

    )
        private set
    var preguntasNormales by mutableStateOf(mutableListOf(
        Preguntas.quiz(
            "¿Cuál es la capital de Australia?",
            mutableListOf("Sídney", "Melbourne", "Canberra", "Brisbane"),
            "Canberra"
        ),
        Preguntas.quiz(
            "¿Quién pintó 'La última cena'?",
            mutableListOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Michelangelo"),
            "Leonardo da Vinci"
        ),
        Preguntas.quiz(
            "¿Cuál es el río más largo de América del Norte?",
            mutableListOf("Mississippi", "Misisipi", "Yukón", "Colorado"),
            "Mississippi"
        ),
        Preguntas.quiz(
            "¿Cuál es el color secundario obtenido al mezclar azul y amarillo?",
            mutableListOf("Verde", "Naranja", "Violeta", "Marrón"),
            "Verde"
        ),
        Preguntas.quiz(
            "¿Cuántos días tiene el mes de abril?",
            mutableListOf("28", "29", "30", "31"),
            "30"
        ),
        Preguntas.quiz(
            "¿Cuál es el planeta más grande del sistema solar?",
            mutableListOf("Júpiter", "Saturno", "Urano", "Neptuno"),
            "Júpiter"
        ),
        Preguntas.quiz(
            "¿Cuál es el animal marino más grande del mundo?",
            mutableListOf("Orca", "Cachalote", "Tiburón ballena", "Calamar gigante"),
            "Tiburón ballena"
        ),
        Preguntas.quiz(
            "¿Cuál es el segundo océano más grande del mundo?",
            mutableListOf("Océano Atlántico", "Océano Índico", "Océano Pacífico", "Océano Ártico"),
            "Océano Atlántico"
        ),
        Preguntas.quiz(
            "¿Cuál es el resultado de multiplicar 5 por 8?",
            mutableListOf("20", "30", "35", "40"),
            "40"
        ),
        Preguntas.quiz(
            "¿Cuál es el idioma oficial de Brasil?",
            mutableListOf("Inglés", "Español", "Portugués", "Francés"),
            "Portugués"
        ),
        Preguntas.quiz(
            "¿En qué año se firmó la Declaración de Independencia de Estados Unidos?",
            mutableListOf("1776", "1789", "1812", "1865"),
            "1776"
        ),
        Preguntas.quiz(
            "¿Cuál es el símbolo químico del carbono?",
            mutableListOf("C", "Co", "Ca", "Cu"),
            "C"
        ),
        Preguntas.quiz(
            "¿Cuál es la montaña más alta de Europa?",
            mutableListOf("Mont Blanc", "Cervino", "Elbrus", "Matterhorn"),
            "Elbrus"
        ),
        Preguntas.quiz(
            "¿Cuál es el número atómico del hierro?",
            mutableListOf("24", "25", "26", "27"),
            "26"
        ),
        Preguntas.quiz(
            "¿Cuál es el autor de la obra '1984'?",
            mutableListOf("George Orwell", "Aldous Huxley", "Ray Bradbury", "Franz Kafka"),
            "George Orwell"
        )
    ))
        private set
    var preguntasDificiles by mutableStateOf(mutableListOf(
        Preguntas.quiz(
            "¿Cuál es la capital de Mongolia?",
            mutableListOf("Pekín", "Moscú", "Ulán Bator", "Bangkok"),
            "Ulán Bator"
        ),
        Preguntas.quiz(
            "¿Quién escribió la obra 'Moby-Dick'?",
            mutableListOf("Herman Melville", "Mark Twain", "Nathaniel Hawthorne", "Charles Dickens"),
            "Herman Melville"
        ),
        Preguntas.quiz(
            "¿Cuál es el río más largo de América del Sur?",
            mutableListOf("Amazonas", "Nilo", "Misisipi", "Yangtsé"),
            "Amazonas"
        ),
        Preguntas.quiz(
            "¿Cuál es el color obtenido al mezclar azul, rojo y amarillo?",
            mutableListOf("Verde", "Naranja", "Violeta", "Marrón"),
            "Marrón"
        ),
        Preguntas.quiz(
            "¿Cuántos días tiene el mes de junio?",
            mutableListOf("28", "29", "30", "31"),
            "30"
        ),
        Preguntas.quiz(
            "¿Cuál es el planeta más pequeño del sistema solar?",
            mutableListOf("Mercurio", "Venus", "Marte", "Plutón"),
            "Mercurio"
        ),
        Preguntas.quiz(
            "¿Cuál es el animal más rápido del mundo?",
            mutableListOf("Guepardo", "León", "Águila", "Flecha"),
            "Guepardo"
        ),
        Preguntas.quiz(
            "¿Cuál es el océano más profundo del mundo?",
            mutableListOf("Océano Pacífico", "Océano Atlántico", "Océano Índico", "Océano Ártico"),
            "Océano Pacífico"
        ),
        Preguntas.quiz(
            "¿Cuál es el resultado de dividir 100 entre 7?",
            mutableListOf("14", "15", "16", "17"),
            "14"
        ),
        Preguntas.quiz(
            "¿Cuál es el idioma oficial de Japón?",
            mutableListOf("Chino", "Coreano", "Japonés", "Tailandés"),
            "Japonés"
        ),
        Preguntas.quiz(
            "¿En qué año comenzó la Primera Guerra Mundial?",
            mutableListOf("1905", "1914", "1918", "1939"),
            "1914"
        ),
        Preguntas.quiz(
            "¿Cuál es el símbolo químico del calcio?",
            mutableListOf("Ca", "Cu", "Co", "C"),
            "Ca"
        ),
        Preguntas.quiz(
            "¿Cuál es la montaña más alta de África?",
            mutableListOf("Monte Everest", "Mont Blanc", "Monte Kilimanjaro", "Matterhorn"),
            "Monte Kilimanjaro"
        ),
        Preguntas.quiz(
            "¿Cuál es el número atómico del plomo?",
            mutableListOf("78", "79", "80", "82"),
            "82"
        ),
        Preguntas.quiz(
            "¿Cuál es el autor de la obra 'Cien años de soledad'?",
            mutableListOf("Gabriel García Márquez", "Jorge Luis Borges", "Pablo Neruda", "Mario Vargas Llosa"),
            "Gabriel García Márquez"
        )
    ))
        private set

    //MODIFICACIONES DE VARIABLES
    fun aumentarPuntuacion(){
        puntuacion++
    }
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
        fondo =if (!darkmode){ R.drawable.blanco }else R.drawable.negro
    }
}