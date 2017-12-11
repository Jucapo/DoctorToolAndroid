package com.example.intel.doctortool
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.intel.doctortool.fragments_formulas.*

class FormulaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula)

        val pos = intent.extras.getInt("pos", 0)

        when(pos){
            0 -> putFragment(R.id.containerFormula , Apache2_Fragment.instance())
            1 -> putFragment(R.id.containerFormula , ASC_Fragment.instance())
            2 -> putFragment(R.id.containerFormula , EdadG_Fragment.instance())
            3 -> putFragment(R.id.containerFormula , FPP_Fragment.instance())
            4 -> putFragment(R.id.containerFormula , Gupta_Fragment.instance())
            5 -> putFragment(R.id.containerFormula , Holliday_Fragment.instance())
            6 -> putFragment(R.id.containerFormula , IMC_Fragment.instance())
            7 -> putFragment(R.id.containerFormula , LEE_Fragment.instance())
            8 -> putFragment(R.id.containerFormula , OSMP_Fragment.instance())
            9 -> putFragment(R.id.containerFormula , PAC_Fragment.instance())
            10 -> putFragment(R.id.containerFormula , PPT_Fragment.instance())
            11 -> putFragment(R.id.containerFormula , PSE_Fragment.instance())
            12 -> putFragment(R.id.containerFormula , PSP_Fragment.instance())
            13 -> putFragment(R.id.containerFormula , TFG_Fragment.instance())
            14 -> putFragment(R.id.containerFormula , VST_Fragment.instance())
        }
    }

    fun putFragment(container: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit()
    }


}
