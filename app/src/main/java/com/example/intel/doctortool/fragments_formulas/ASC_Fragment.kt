package com.example.intel.doctortool.fragments_formulas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.R
import kotlinx.android.synthetic.main.fragment_asc.*


class ASC_Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asc, container, false)
    }

    override fun onResume() {
        super.onResume()
        calculaPSE.setOnClickListener(this::calcular)
    }

    fun calcular(view: View){

        val pr =  pesoASC.text.toString()
        val ar =  alturaASC.text.toString()

        if (pr =="" || ar == ""){
            resultadoASC.text = getString(R.string.errorCampos)
        }
        else {
            val p = pesoASC.text.toString().toDouble()
            val a = alturaASC.text.toString().toDouble()
            val result = Math.sqrt(a * p) / 60
            val res = String.format("%.3f", result)
            resultadoASC.text = "ASC = $res metros"
        }
    }

    companion object {
        fun instance(): ASC_Fragment = ASC_Fragment()
    }

}


