package com.example.intel.doctortool.fragments_formulas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.intel.doctortool.R
import kotlinx.android.synthetic.main.fragment_imc.*


class IMC_Fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imc, container, false)
    }

    override fun onResume() {
        super.onResume()
        calculaPSE.setOnClickListener(this::calcular)
    }

    fun calcular(view: View){

        val pr =  pesoASC.text.toString()
        val ar =  alturaASC.text.toString()

        if (pr=="" || ar==""){
            resultadoIMC.text = getString(R.string.errorCampos)
        }
        else {
            val p = pesoASC.text.toString().toDouble()
            val a = alturaASC.text.toString().toDouble()
            val result = p / (a * a)
            val res = String.format("%.3f", result)
            resultadoIMC.text = "IMC = $res"
        }
    }

    companion object {
        fun instance():IMC_Fragment  = IMC_Fragment()
    }

}
