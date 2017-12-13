package com.example.intel.doctortool.fragments_formulas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.R
import kotlinx.android.synthetic.main.fragment_fpp.*


class FPP_Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fpp, container, false)
    }

    override fun onResume() {
        super.onResume()
        calculaPSE.setOnClickListener(this::calcular)
    }

    fun calcular(view: View){
        val fum =  pesoASC.text.toString().toInt()
        resultadoFPP.text = "Edad G = $fum"
    }

    companion object {
        fun instance():FPP_Fragment  = FPP_Fragment()
    }

}
