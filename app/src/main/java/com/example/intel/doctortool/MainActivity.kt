package com.example.intel.doctortool

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.intel.doctortool.adapter.CustomPagerAdapter
import com.example.intel.doctortool.fragments.EspecialidadFragment
import com.example.intel.doctortool.fragments.FavoritosFragment
import com.example.intel.doctortool.fragments.RecientesFragment
import com.example.intel.doctortool.fragments.TodasFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.*


class MainActivity : AppCompatActivity() {

    //setting up pageradapter
    var pagerAdapter: CustomPagerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)

        pagerAdapter = CustomPagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(FavoritosFragment(),"Favoritos")
        pagerAdapter!!.addFragments(RecientesFragment(),"Recientes")
        pagerAdapter!!.addFragments(EspecialidadFragment(),"Especialidad")
        pagerAdapter!!.addFragments(TodasFragment(),"Todas")

        //addding  pageadapter to viewpager

        customViewPager.adapter = pagerAdapter
        customTabLayout.setupWithViewPager(customViewPager)




    }
}
