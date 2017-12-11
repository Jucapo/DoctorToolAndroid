package com.example.intel.doctortool.Formulas

import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(layout:Int) = LayoutInflater
        .from(context).inflate(layout, this, false)