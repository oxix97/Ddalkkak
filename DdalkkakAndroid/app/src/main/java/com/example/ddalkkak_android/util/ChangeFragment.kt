package com.example.ddalkkak_android.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.changeFragment(layoutRes: Int, fragment: Fragment, name: String) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(layoutRes, fragment)
        .addToBackStack(name)
        .commit()
}

fun AppCompatActivity.changeFragmentNoBackStack(layoutRes: Int, fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(layoutRes, fragment)
        .commit()
}
