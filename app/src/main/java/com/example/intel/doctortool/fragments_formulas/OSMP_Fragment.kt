package com.example.intel.doctortool.fragments_formulas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.intel.doctortool.R
import kotlinx.android.synthetic.main.fragment_osmp.*


class OSMP_Fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_osmp, container, false)
    }


    override fun onResume() {
        super.onResume()
        calculaPSE.setOnClickListener(this::calcular)
    }

    fun calcular(view: View){
        val naR =  pesoASC.text.toString()
        val gluR =  alturaASC.text.toString()
        val bunR =  bunOSMP.text.toString()

        if(naR=="" ||  gluR=="" || bunR==""){
            resultadoOSMP.text = getString(R.string.errorCampos)
        }
        else {
            val na = pesoASC.text.toString().toDouble()
            val glu = alturaASC.text.toString().toDouble()
            val bun = bunOSMP.text.toString().toDouble()
            val result = 2 * na + (glu / 18) + (bun / 2.8)
            val res = String.format("%.4f", result)
            resultadoOSMP.text = "OSMP = $res"
        }
    }



    companion object {
        fun instance():OSMP_Fragment  = OSMP_Fragment()
    }

}// Required empty public constructor
