package com.cantek.jamune

import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUdapter();

    }

    private fun setUdapter() {
        val pager = MainAdapter(supportFragmentManager)
        pager.addFragment(list(),"")
        pager.addFragment(category(),"")
        viewPager.adapter = pager
        tabs.setupWithViewPager(viewPager)
    }
}