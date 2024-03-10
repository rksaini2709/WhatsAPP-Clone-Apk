package com.example.whatsappcloneapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.whatsappcloneapk.adapter.ViewPagerAdapter
import com.example.whatsappcloneapk.ui.CallsFragment
import com.example.whatsappcloneapk.ui.ChatsFragment
import com.example.whatsappcloneapk.ui.StatusFragment
import com.example.whatsappcloneapk.databinding.ActivityHomePageBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomePage : AppCompatActivity() {

    private var binding: ActivityHomePageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Generated binding class ka use karke layout ko inflate karo
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        // ViewPager ke liye fragments ko hold karne ke liye list banao
        val fragmentArrayList = ArrayList<Fragment>()

        // ChatsFragment, StatusFragment, aur CallsFragment ke instances ko list mei add karo
        fragmentArrayList.add(ChatsFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallsFragment())

        // Fragment list ke saath ViewPagerAdapter ka ek instance banao
        val adapter = ViewPagerAdapter(this, supportFragmentManager, lifecycle, fragmentArrayList)

        // ViewPager ke liye adapter set karo
        binding!!.viewPager.adapter = adapter

        // TabLayout aur ViewPager ko link karne ke liye TabLayoutMediator ka use karo
        TabLayoutMediator(binding!!.tabs, binding!!.viewPager) { tab, position ->
            // Fragment position ke basis par tab labels ya icons ko customize karo
            when (position) {
                0 -> tab.text = "Chats"
                1 -> tab.text = "Status"
                2 -> tab.text = "Calls"
            }
        }.attach()
    }
}
