package com.example.intel.doctortool
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intel.doctortool.models.perfil
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_editar_perfil.*
import org.jetbrains.anko.toast
import android.widget.ArrayAdapter
import android.widget.Spinner


class EditarPerfilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val spinner = findViewById<View>(R.id.spinner) as Spinner
        val adapter = ArrayAdapter.createFromResource(this,R.array.especialidades_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnGuardarPerfil.setOnClickListener(this::savePerfil)
    }

    fun savePerfil(view: View){

        var nombre = nombreText.text.toString()
        var apellidos = apellidosText.text.toString()
        var edad =  edadText.text.toString()
        var especialidad =  "General"
        val ref = FirebaseDatabase.getInstance().getReference("Perfil")
        val perfilId = ref.push().key
        val perfil = perfil(perfilId,nombre,apellidos,edad,especialidad)

        ref.setValue(perfil).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                toast(R.string.perfilOK)
                val intent = Intent(this, bottomNavigationActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                toast(R.string.perfilError)
                nombreText.setText("")
                apellidosText.setText("")
                edadText.setText("")
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, bottomNavigationActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }




}
