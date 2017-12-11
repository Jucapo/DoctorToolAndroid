package com.example.intel.doctortool.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class CustomPagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm) {

    var mFm= fm
    var mFragmentItems:ArrayList<Fragment> = ArrayList()
    var mFragmentTitles: ArrayList<String> = ArrayList()


    fun addFragments(fragmentItem:Fragment, fragmentTitle:String){
        mFragmentTitles.add(fragmentTitle)
        mFragmentItems.add(fragmentItem)
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentItems[position]
        }

    override fun getCount(): Int {
        return mFragmentItems.size
        }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitles[position]
    }
}