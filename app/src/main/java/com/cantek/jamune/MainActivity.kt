package com.cantek.jamune

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.cantek.jamune.adapter.PageAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        val viewPager: ViewPager = findViewById(R.id.main_view_pager)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}