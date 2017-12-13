package com.example.intel.doctortool.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.R
import com.example.intel.doctortool.models.perfil
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_especialidad.*


class EspecialidadFragment : Fragment() {



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
            }
        })

        return inflater.inflate(R.layout.fragment_especialidad, container, false)
    }
    companion object {
        fun instance():EspecialidadFragment = EspecialidadFragment()
    }

    override fun onResume() {
        super.onResume()


    }


}// Required empty public constructor
