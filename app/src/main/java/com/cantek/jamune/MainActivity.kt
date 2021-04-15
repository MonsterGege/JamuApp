package com.cantek.jamune

import android.app.Activity
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.cantek.jamune.adapter.PageAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Jamune)
        setContentView(R.layout.activity_main)
        val tabLayout: TabLayout = findViewById(R.id.tabs)
        val viewPager: ViewPager = findViewById(R.id.main_view_pager)
        val search: SearchView = findViewById(R.id.search)

        viewPager.adapter = PageAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}