package com.example.ud06_3_hangedman

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Collections.list

class GameViewModel : ViewModel() {
    val palabras = listOf(
        "perro","vaca","pandilla",
        "letra","pipo","carrusel",
        "Prueba", "botella", "movil",
        "mimo","Estudio","odio",
        "avaricia","tesoro","Coco" )

    var palabraR = palabras.random().uppercase()

    var palabraHidden = ""

    var vidas = 7
    var contiene = false

    val charList: MutableList<Char> = mutableListOf()

    var ganador = 0

    var cont = 0;

    fun resetGame() {
        palabraR = palabras.random().uppercase() // Reasignar una nueva palabra aleatoria
        palabraHidden = mostrarPalabraHidden(emptyList()) // Reiniciar la palabra oculta
        vidas = 7 // Restablecer vidas
        charList.clear() // Limpiar las letras ya intentadas
        ganador = 0 // Resetear el estado de ganador
        cont = 0
        contiene = false
    }

    fun mostrarPalabraHidden(listChar : List<Char>) = //este igual es un return
        //map recorre el string y te da char, it es un chat, es como un foreach
        palabraR.map {
            if (listChar.contains(it)) it
            else "_"  //esta devolviendo barra baja por cada char
        }.joinToString(" ") //se pasa a string y se suma un espacio

    fun guess (charAttempt : Char){//le añades el tipo de var para poder acceder a las funciones d ela clase char
        charAttempt.uppercaseChar()
        contiene = false
        cont= 0

        if (!charList.contains(charAttempt.uppercaseChar())) {
            // Solo agregamos si no está en la lista
            charList.add(charAttempt.uppercaseChar())
        } else {
            cont = 1
            contiene = true
        }

        if (palabraR.contains(charAttempt.uppercaseChar())){
            contiene = true
        }

        if (!contiene){
            vidas --
        }

        palabraHidden = mostrarPalabraHidden(charList)
    }

    fun inicio (charAttempt: Char){
        palabraHidden = mostrarPalabraHidden(charList)
    }


}