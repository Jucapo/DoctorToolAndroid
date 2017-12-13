package com.example.intel.doctortool.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.FormulaActivity
import com.example.intel.doctortool.Formulas.*
import com.example.intel.doctortool.R
import com.example.intel.doctortool.adapter.FormulaAdapter
import com.example.intel.doctortool.models.perfil
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_especialidad.*
import kotlinx.android.synthetic.main.fragment_todas.*
import org.jetbrains.anko.support.v4.startActivity


class EspecialidadFragment : Fragment() {

    val adapter: FormulaAdapter = FormulaAdapter(this::formulaSelected)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val ref = FirebaseDatabase.getInstance().getReference("Perfil")
        ref.addValueEventListener(object : ValueEventListener{

            override fun onCancelled(p0: DatabaseError?) {

            }
            override fun onDataChange(p0: DataSnapshot?) {
                val post = p0?.getValue(perfil::class.java)
                val espe = post?.especialidad
                especialidadText.text = espe

                listEspecialidad.adapter = adapter
                listEspecialidad.layoutManager = LinearLayoutManager(activity)
                when(espe){
                    "General"           -> adapter.data = DataGeneral.formulasGe
                    "Anestesiologia"    -> adapter.data = DataAnestesiologia.formulasAnes
                    "Medicina Interna"  -> adapter.data = DataMedicinaInterna.formulasMe
                    "GinecoObstetricia" -> adapter.data = DataGineco.formulasGineco
                    "Cirugia General"   -> adapter.data = DataCirugia.formulasCirugia
                    "Pediatria"         -> adapter.data = DataPediatria.formulasPediatria
                }
            }
        })
        return inflater.inflate(R.layout.fragment_especialidad, container, false)
    }


    override fun onResume() {
        super.onResume()

    }

    fun formulaSelected(pos:Int){
        startActivity<FormulaActivity>("pos" to pos)
    }

    companion object {
        fun instance():EspecialidadFragment = EspecialidadFragment()
    }

}
