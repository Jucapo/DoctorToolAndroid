package com.example.intel.doctortool
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import com.example.intel.doctortool.fragments.*
import com.example.intel.doctortool.models.perfil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

import kotlinx.android.synthetic.main.nav_head.*

class bottomNavigationActivity : AppCompatActivity(), DrawerLayout.DrawerListener {


    val toggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, drawer,
                R.string.open_menu, R.string.close_menu)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_recientes -> {
                putFragment(R.id.containerFragment , RecientesFragment.instance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_todas -> {
                putFragment(R.id.containerFragment , TodasFragment.instance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_especialidad -> {
                putFragment(R.id.containerFragment , EspecialidadFragment.instance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        putFragment(R.id.containerFragment , TodasFragment.instance())

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(this)
        nav.setNavigationItemSelectedListener { setContent(it) }

        val ref = FirebaseDatabase.getInstance().getReference("Perfil")
        ref.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError?) {

            }
            override fun onDataChange(p0: DataSnapshot?) {
                val post = p0?.getValue(perfil::class.java)
                val espe = post?.especialidad
                val nombre = post?.nombre
                val apellidos = post?.apellidos
                if(nombre ==null || apellidos == null || espe==null){
                    nombreCText.text = "¡¡Crea tu perfil ahora!! =)"
                }
                else {
                    nombreCText.text = "$nombre $apellidos"
                    espePerfilText.text = espe
                }
            }
        })


    }

    fun putFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit()
    }

    fun setContent(item: MenuItem?): Boolean {
        drawer.closeDrawers()
        when(item?.itemId){
            R.id.nav_home -> putFragment(R.id.container, TodasFragment.instance())
            R.id.nav_logut -> {
                getSharedPreferences("preferencias", Context.MODE_PRIVATE).edit()
                        .putBoolean("logged", false).apply()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_perfil -> {
                val intent = Intent(this, EditarPerfilActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_configuraciones -> {
                val intent = Intent(this, Configuraciones_Activity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return true
    }


    //<editor-fold desc="Toggle">
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onDrawerStateChanged(newState: Int) {
        toggle.onDrawerStateChanged(newState)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        toggle.onDrawerSlide(drawerView, slideOffset)
    }

    override fun onDrawerClosed(drawerView: View) {
        toggle.onDrawerClosed(drawerView)
    }

    override fun onDrawerOpened(drawerView: View) {
        toggle.onDrawerOpened(drawerView)
    }
    //</editor-fold>




}
