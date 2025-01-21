package com.example.ud06_3_hangedman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ud06_3_hangedman.databinding.FragmentGameBinding


class GameFragment : Fragment() {

    var bindingNull: FragmentGameBinding? = null
    val binding: FragmentGameBinding
        get() = bindingNull!!

    //para recoger las palabras
    val model : GameViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingNull = FragmentGameBinding.inflate(inflater,container,false)
        val vista = binding.root

        binding.vidasID.text = model.vidas.toString();

        model.inicio(' ')

        binding.secretWorldID.text = model.palabraHidden

        binding.siguienteID.setOnClickListener{

            val caracter = binding.inputTextID.text.toString()
            model.guess(caracter[0])

            binding.secretWorldID.text = model.palabraHidden
            binding.vidasID.text = model.vidas.toString();

            if (model.cont == 1){
                Toast.makeText(activity, "Ya has intentado esa letra", Toast.LENGTH_SHORT).show()
            }

            if (model.vidas == 0 ){
                model.ganador = 0
                vista.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }else if(!model.palabraHidden.contains("_")){

                model.ganador = 1
                vista.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }

            binding.inputTextID.text.clear()

        }

        // Inflate the layout for this fragment
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingNull = null
    }
}