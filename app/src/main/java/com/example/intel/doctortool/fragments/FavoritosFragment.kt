package com.example.intel.doctortool.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.intel.doctortool.LoginActivity
import com.example.intel.doctortool.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_favoritos.*
import org.jetbrains.anko.support.v4.startActivity


class FavoritosFragment : Fragment() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false)

        mAuth = FirebaseAuth.getInstance()

        btnclose.setOnClickListener(this::Cerrar)

    }

    fun Cerrar(view: View){
        mAuth?.signOut()
        startActivity<LoginActivity>()
    }

}
