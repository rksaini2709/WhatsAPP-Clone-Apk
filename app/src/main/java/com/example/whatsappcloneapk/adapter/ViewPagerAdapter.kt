package com.example.whatsappcloneapk.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPagerAdapter class that extends FragmentStateAdapter
class ViewPagerAdapter(
    private val context: Context,                  // Context of the application
    fragmentManager: FragmentManager,              // FragmentManager to interact with fragments
    lifecycle: Lifecycle,                          // Lifecycle of the containing component (Activity or Fragment)
    private val list: ArrayList<Fragment>           // List of Fragments to display in the ViewPager
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    // Returns the total number of fragments in the ViewPager
    override fun getItemCount(): Int {
        return list.size
    }

    // Creates and returns a Fragment for the given position
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

    // Companion object containing an array of tab titles
    companion object {
        val TAB_TITLES = arrayOf("Chats", "Status", "Calls")
    }
}
