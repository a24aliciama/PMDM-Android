package com.example.ud05_1_justit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_order, container, false)

        //cogemos la barra para una variable
        val barraHerramientas = vista.findViewById<MaterialToolbar>(R.id.toolBarId)

        //para crear la barra de este fragmento por defecto
        //cogimos getActivity y casteamos AppCompatActivity que hereda de activity
        (activity as AppCompatActivity).setSupportActionBar(barraHerramientas)

        //devolvemos la vista
        return vista
    }

}