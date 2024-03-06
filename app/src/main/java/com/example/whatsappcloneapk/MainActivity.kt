package com.example.whatsappcloneapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.whatsappcloneapk.adapter.ViewPagerAdapter
import com.example.whatsappcloneapk.ui.CallsFragment
import com.example.whatsappcloneapk.ui.ChatsFragment
import com.example.whatsappcloneapk.ui.StatusFragment
import com.example.whatsappcloneapk.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using the generated binding class
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        // Create a list to hold the fragments for the ViewPager
        val fragmentArrayList = ArrayList<Fragment>()

        // Add instances of ChatsFragment, StatusFragment, and CallsFragment to the list
        fragmentArrayList.add(ChatsFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallsFragment())

        // Create an instance of the ViewPagerAdapter with the fragment list
        val adapter = ViewPagerAdapter(this, supportFragmentManager, lifecycle, fragmentArrayList)

        // Set the adapter for the ViewPager
        binding!!.viewPager.adapter = adapter

        // Use TabLayoutMediator to link the TabLayout and ViewPager
        TabLayoutMediator(binding!!.tabs, binding!!.viewPager) { tab, position ->
            // Customize tab labels or icons based on the fragment position
            when (position) {
                0 -> tab.text = "Chats"
                1 -> tab.text = "Status"
                2 -> tab.text = "Calls"
            }
        }.attach()
    }
}
