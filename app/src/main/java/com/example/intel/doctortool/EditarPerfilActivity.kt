package com.example.intel.doctortool
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import com.example.intel.doctortool.models.perfil
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_editar_perfil.*
import org.jetbrains.anko.toast
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.intel.doctortool.R.array.especialidades_array
import org.jetbrains.anko.sp


class EditarPerfilActivity : AppCompatActivity() {


    var especilidadG:String ="1"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_perfil)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val spinner = findViewById<View>(R.id.spinner) as Spinner
        val adapter = ArrayAdapter.createFromResource(this,R.array.especialidades_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val espec = p0?.getItemAtPosition(p2)
                especilidadG = espec.toString()
            }
        }

        btnGuardarPerfil.setOnClickListener(this::savePerfil)
    }

    fun savePerfil(view: View){



        var nombre = nombreText.text.toString()
        var apellidos = apellidosText.text.toString()
        var edad =  edadText.text.toString()
        var especialidad =  especilidadG
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
