package com.example.intel.doctortool.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.intel.doctortool.R


/**
 * A simple [Fragment] subclass.
 */
class RecientesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recientes, container, false)
    }

    companion object {
        fun instance():RecientesFragment = RecientesFragment()
    }

}// Required empty public constructor
