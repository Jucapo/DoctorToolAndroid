package com.example.intel.doctortool

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast


class RegisterActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        btnRegister2.setOnClickListener(this::registro)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

 fun registro(view: View){

     val email = emailRegister.text.toString()
     val pass  = passRegister.text.toString()

     RegistroFirebase(email,pass)
 }

    fun RegistroFirebase (email:String , password:String){

        mAuth?.createUserWithEmailAndPassword(email, password)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    toast(R.string.registroOK)
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                    val user = mAuth?.getCurrentUser()
                } else {
                    toast(R.string.registroERROR)
                    emailRegister.setText("")
                    passRegister.setText("")
                }
            }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    }





