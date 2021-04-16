package com.cantek.jamune

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
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


        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                val i = Intent(this@MainActivity,Search::class.java)
                i.putExtra("key-query",query)
                startActivity(i)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        viewPager.adapter = PageAdapter(this, supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}