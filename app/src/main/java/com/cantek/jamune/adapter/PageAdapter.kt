package com.cantek.jamune.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cantek.jamune.Category
import com.cantek.jamune.List

class PageAdapter(context: Context ,fm: FragmentManager): FragmentPagerAdapter(fm) {
    lateinit var konteks: Context
    init {
        konteks = context
    }
    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> return List(konteks)
            1 -> return Category()
            else -> return List(konteks)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> return "All Receipe"
            1 -> return "Category"
        }
        return super.getPageTitle(position)
    }

    override fun getCount(): Int {
        return 2
    }

}