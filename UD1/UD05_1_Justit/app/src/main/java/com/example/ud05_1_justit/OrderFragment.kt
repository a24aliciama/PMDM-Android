package com.example.ud05_1_justit

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ud05_1_justit.databinding.FragmentOrderBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {


    var bindingNull: FragmentOrderBinding? = null
    val binding: FragmentOrderBinding
        get() = bindingNull!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val vista = inflater.inflate(R.layout.fragment_order, container, false)
        bindingNull = FragmentOrderBinding.inflate(inflater,container,false)

        val vista = binding.root

        //cogemos la barra para una variable
        val barraHerramientas = vista.findViewById<MaterialToolbar>(R.id.toolBarId)

        //para crear la barra de este fragmento por defecto
        //cogimos getActivity y casteamos AppCompatActivity que hereda de activity
        (activity as AppCompatActivity).setSupportActionBar(barraHerramientas)


        //vamos a poner una accion al fav floatboton

        val botonFlotante =  vista.findViewById<FloatingActionButton>(R.id.botonfloatID)

        botonFlotante.setOnClickListener{

            //Primero, necesitas obtener los elementos de la interfaz que el usuario puede seleccionar.
            //Este es el grupo de opciones para las hamburguesas (radio buttons).
            val grupoBurguer = vista.findViewById<RadioGroup>(R.id.radioBotonsID)
            val tipoBurguer = grupoBurguer.checkedRadioButtonId

            //Este es el grupo de chips donde el usuario puede seleccionar ingredientes.
            val grupoIngre = vista.findViewById<ChipGroup>(R.id.ingredientesID)
            val tipoIngre = grupoIngre.checkedChipId

            //A continuación, verificamos si el usuario ha elegido una hamburguesa.
            //Esto obtiene el ID de la opción de hamburguesa que el usuario ha seleccionado. Si no hay selección, devuelve -1.
                if (tipoBurguer == -1){
                    //Si el valor es -1, mostramos un mensaje que le dice al usuario que debe seleccionar una hamburguesa.
                    Toast.makeText(activity,"seleciona una hamburguesa", Toast.LENGTH_SHORT).show()
                }else{
                    //Si el usuario ha seleccionado una hamburguesa, comenzamos a construir el mensaje que vamos a mostrar.

                    var mensaje ="Has seleccionado: "

                    //Aquí estamos añadiendo al mensaje el tipo de hamburguesa seleccionada usando when, que funciona como un "si-esto-entonces" para elegir el texto correcto.
                    mensaje += when(tipoBurguer){
                        R.id.radioCatID -> getString(R.string.hamburguesa)
                        R.id.radioTofuID -> getString(R.string.tofurguer)
                        R.id.radioCerdoID -> getString(R.string.cerdurguer)
                        R.id.radioTerneraID -> getString( R.string.vacurguer)
                        R.id.radioPolloID -> getString(R.string.pollurguer)
                        else -> {"...ERROR..."}
                    }
                    //Crea una lista vacía donde guardaremos los ingredientes seleccionados.
                    val ingredientesSeleccionados = mutableListOf<String>()

                    //El bucle for recorre todos los chips en grupoIngre.
                    for (i in 0 until grupoIngre.childCount) {
                        val chip = grupoIngre.getChildAt(i) as Chip
                        //Verifica si un chip está seleccionado. Si lo está, lo añadimos a la lista ingredientesSeleccionados
                        if (chip.isChecked)
                        {
                            ingredientesSeleccionados.add(chip.text.toString())
                        }
                    }
                    //isEmpty(): Verifica si no hay ingredientes seleccionados.
                    if (ingredientesSeleccionados.isEmpty()) {
                        mensaje += " sola."
                    } else {
                        //joinToString(", "): Une los nombres de los ingredientes seleccionados en una sola cadena, separados por comas.
                        mensaje += " con " + ingredientesSeleccionados.joinToString(", ") + "."
                    }

                    //Por último, puedes mostrar el mensaje al usuario.
                   /* val sms = Snackbar.make(botonFlotante, mensaje, Snackbar.LENGTH_LONG)

                    sms.setAction("Cancelar"){
                        grupoBurguer.clearCheck()
                        grupoIngre.clearCheck()
                    }

                    sms.show()
                    */
                    //como no me cabia el mensaje
                    val builder = AlertDialog.Builder(activity)
                    builder.setTitle("Resumen de tu pedido")
                    builder.setMessage(mensaje)
                    builder.setPositiveButton("Aceptar") { dialog, _ ->
                        dialog.dismiss()
                        Toast.makeText(activity,"Enviando, hamburguesa", Toast.LENGTH_SHORT).show()
                    }
                    builder.setNegativeButton("Cancelar") { dialog, _ ->
                        grupoBurguer.clearCheck()
                        grupoIngre.clearCheck()
                        dialog.dismiss()
                    }

                    builder.show()
                }


    }

        //devolvemos la vista
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingNull = null
    }

}