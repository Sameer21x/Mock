package com.example.lab15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private val TAG_LIST_FRAGMENT = "CRIME_LIST_FRAGMENT"
    var mCrimeListFragment: CrimeListFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm: FragmentManager = supportFragmentManager

        if (savedInstanceState == null) {
            val ft: FragmentTransaction = fm.beginTransaction()
            mCrimeListFragment = CrimeListFragment()
            ft.add(
                R.id.main_activity_frame,
                mCrimeListFragment!!,
                TAG_LIST_FRAGMENT
            )
            ft.commitNow()
        } else {
            mCrimeListFragment = fm.findFragmentByTag(TAG_LIST_FRAGMENT) as CrimeListFragment?
        }
    }
}
