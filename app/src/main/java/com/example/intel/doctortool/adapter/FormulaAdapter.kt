package com.example.intel.doctortool.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.Formulas.inflate
import com.example.intel.doctortool.R
import com.example.intel.doctortool.databinding.TemplateFormulaBinding
import com.example.intel.doctortool.models.Formula


class FormulaAdapter(val callback:(pos:Int)->Unit):RecyclerView.Adapter<FormulaViewHolder>(){

    var data: List<Formula> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: FormulaViewHolder, position: Int) {
        holder.binding.formula = data[position]
        holder.binding.root.tag = position
        holder.binding.handler = this
    }

    fun onFormulaClick(pos:Int){
        callback(pos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulaViewHolder
            = FormulaViewHolder(parent.inflate(R.layout.template_formula))

    override fun getItemCount(): Int = data.size


}

class FormulaViewHolder(view:View):RecyclerView.ViewHolder(view){
        val binding:TemplateFormulaBinding = DataBindingUtil.bind(view)
}