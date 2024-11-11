package com.example.ud06_3_hangedman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.ud06_3_hangedman.databinding.FragmentGameBinding
import com.example.ud06_3_hangedman.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    var bindingNull: FragmentResultBinding? = null
    val binding: FragmentResultBinding
        get() = bindingNull!!

    val model : GameViewModel by viewModels(
        ownerProducer = {this.requireActivity()}
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingNull = FragmentResultBinding.inflate(inflater,container,false)
        val vista = binding.root

        if (model.ganador == 0){
            binding.ganadorID.text = buildString {
                append("Has perdido, la palabra era: ")
                append(model.palabraR)
            }
        }else if (model.ganador == 1){
            binding.ganadorID.text = buildString {
                append("GANASTE")
            }
        }

        binding.aceptarID.setOnClickListener{
            Toast.makeText(activity, model.palabraR, Toast.LENGTH_LONG).show()
        }

        // Inflate the layout for this fragment
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingNull = null
    }
}
