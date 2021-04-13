package com.cantek.jamune

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class MainAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragmentlist = ArrayList<Fragment>()
    private val title  = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentlist[position]
    }

    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }

    fun addFragment(fragment: Fragment,titles:String){
        fragmentlist.add(fragment)
        title.add(titles)
    }
}