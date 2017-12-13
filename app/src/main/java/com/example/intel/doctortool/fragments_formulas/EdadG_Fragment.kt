package com.example.intel.doctortool.fragments_formulas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.intel.doctortool.R
import kotlinx.android.synthetic.main.fragment_edad_g.*


/**
 * A simple [Fragment] subclass.
 */
class EdadG_Fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edad_g, container, false)
    }

    override fun onResume() {
        super.onResume()
        calculaPSE.setOnClickListener(this::calcular)
    }

    fun calcular(view: View){
        val edadG =  pesoASC.text.toString().toInt()
        resultadoEdadG.text = "Edad G = $edadG"
    }

    companion object {
        fun instance():EdadG_Fragment  = EdadG_Fragment()
    }

}// Required empty public constructor
