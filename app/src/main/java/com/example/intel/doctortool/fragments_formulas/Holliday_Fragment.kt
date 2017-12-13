package com.example.intel.doctortool.fragments_formulas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.R
import kotlinx.android.synthetic.main.fragment_holliday.*


class Holliday_Fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holliday, container, false)
    }


    override fun onResume() {
        super.onResume()
        calculaPSE.setOnClickListener(this::calcular)
    }

    fun calcular(view: View){
        val peso =  pesoASC.text.toString().toDouble()
        val tiempo =  alturaASC.text.toString().toDouble()


        when {
            peso <= 10 -> {
                val holliday = tiempo * (peso * 4)
                val res = String.format("%.3f", holliday)
                resultadoHOLLIDAY.text = "Liquidos H = $res ml"
            }
            peso <= 20 -> {
                val holliday = tiempo * ((40) + ((peso - 10) * 2))
                val res = String.format("%.3f", holliday)
                resultadoHOLLIDAY.text = "Liquidos H = $res ml"
            }
            peso > 20 -> {
                val holliday = tiempo * ((60) + ((peso - 20)))
                val res = String.format("%.3f", holliday)
                resultadoHOLLIDAY.text = "Liquidos H = $res ml"
            }
        }


    }


    companion object {
        fun instance():Holliday_Fragment  = Holliday_Fragment()
    }

}// Required empty public constructor
