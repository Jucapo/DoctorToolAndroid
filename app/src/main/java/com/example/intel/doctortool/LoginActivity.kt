package com.example.intel.doctortool

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                val intent = Intent(this, MainActivity::class.java)
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
