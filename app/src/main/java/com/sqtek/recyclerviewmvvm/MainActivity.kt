package com.sqtek.recyclerviewmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sqtek.recyclerviewmvvm.ui.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    private fun loadFragment() {
        val fragmentManager = this.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, MainFragment.newInstance())
        transaction.commit()
    }
}