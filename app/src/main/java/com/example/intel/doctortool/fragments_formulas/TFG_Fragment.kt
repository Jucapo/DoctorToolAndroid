package com.example.intel.doctortool.fragments_formulas


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.intel.doctortool.R


/**
 * A simple [Fragment] subclass.
 */
class TFG_Fragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tfg, container, false)
    }

    companion object {
        fun instance():TFG_Fragment  = TFG_Fragment()
    }

}// Required empty public constructor
