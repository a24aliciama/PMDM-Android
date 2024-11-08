package com.example.ud06_3_hangedman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ud06_3_hangedman.databinding.FragmentGameBinding
import com.example.ud06_3_hangedman.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    var bindingNull: FragmentResultBinding? = null
    val binding: FragmentResultBinding
        get() = bindingNull!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingNull = FragmentResultBinding.inflate(inflater,container,false)
        val vista = binding.root


        // Inflate the layout for this fragment
        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingNull = null
    }
}
