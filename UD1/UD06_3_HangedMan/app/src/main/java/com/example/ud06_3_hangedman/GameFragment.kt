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


        // Observar el LiveData para mostrar el Toast
        model.toastMessage.observe(viewLifecycleOwner, Observer { message ->
            message?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        })

        model.guess(' ')

        binding.secretWorldID.text = model.palabraHidden

        binding.siguienteID.setOnClickListener{
            val caracter = binding.inputTextID.text.toString()
            model.guess(caracter[0])
            binding.secretWorldID.text = model.palabraHidden

            if (model.vidas == 0 ){
                model.ganador = 0
                vista.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }else if(model.palabraR == model.palabraHidden){
                model.ganador = 1
                vista.findNavController().navigate(R.id.action_gameFragment_to_resultFragment)
            }

        }

        // Inflate the layout for this fragment
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingNull = null
    }
}