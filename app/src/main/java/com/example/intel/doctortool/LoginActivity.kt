package com.example.intel.doctortool

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.toast


class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    val preferences:SharedPreferences by lazy { getSharedPreferences("preferencias", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val logged = preferences.getBoolean("logged", false)
        if(logged){
            startActivity<bottomNavigationActivity>()
            finish()
            return
        }

        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        btnLogIn.setOnClickListener(this::login)
        btnRegister.setOnClickListener(this::goRegister)
    }

    fun login(view: View){
        val email = emailLogin.text.toString()
        val pass  = passLogin.text.toString()
        LoginFirebase(email,pass)
    }

    fun LoginFirebase (email:String , password:String){
        mAuth?.signInWithEmailAndPassword(email, password)
        ?.addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                preferences.edit().putBoolean("logged", true).apply()
                val intent = Intent(this, bottomNavigationActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                toast(R.string.LoginError)
            }
        }
    }

    fun goRegister(view: View){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}
