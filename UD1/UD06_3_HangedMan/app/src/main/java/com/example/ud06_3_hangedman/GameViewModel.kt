package com.example.ud06_3_hangedman

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Collections.list

class GameViewModel : ViewModel() {
    val palabras = listOf("vaca","pandilla","letra","pipo","carrusel","Prueba", "mimo","Estudio","odio","avaricia","tesoro","Coco" )

    var palabraR = palabras.random().uppercase()

    var palabraHidden = ""

    var vidas = 7

    val charList: MutableList<Char> = mutableListOf()

    var ganador = 0

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String> get() = _toastMessage

    fun mostrarPalabraHidden(listChar : List<Char>) = //este igual es un return
        //map recorre el string y te da char, it es un chat, es como un foreach
        palabraR.map {
            if (listChar.contains(it)) it
            else "_"  //esta devolviendo barra baja por cada char
        }.joinToString(" ") //se pasa a string y se suma un espacio

    fun guess (charAttempt : Char){ //le añades el tipo de var para poder acceder a las funciones d ela clase char
        if (charList.contains(charAttempt)) {
            // Si la letra ya ha sido intentada, enviar mensaje al fragmento
            _toastMessage.value = "Ya has intentado esa letra"

        } else { // Solo agregamos si no está en la lista
            charList.add(charAttempt.uppercaseChar())

            if (!palabraR.contains(charAttempt)) {  // Si el intento es incorrecto
                vidas--  // Restamos una vida
            }
        }
        palabraHidden = mostrarPalabraHidden(charList)
    }


}