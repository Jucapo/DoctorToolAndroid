package com.example.intel.doctortool.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.support.v4.startActivity
import com.example.intel.doctortool.FormulaActivity
import com.example.intel.doctortool.Formulas.Data
import com.example.intel.doctortool.R
import com.example.intel.doctortool.adapter.FormulaAdapter
import kotlinx.android.synthetic.main.fragment_todas.*


class TodasFragment : Fragment() {

    val adapter:FormulaAdapter = FormulaAdapter(this::formulaSelected)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todas, container, false)
    }

    override fun onResume() {
        super.onResume()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(activity)
        adapter.data = Data.formulas
    }

    fun formulaSelected(pos:Int){
       startActivity<FormulaActivity>("pos" to pos)
    }

    companion object {
        fun instance():TodasFragment = TodasFragment()
    }

}
