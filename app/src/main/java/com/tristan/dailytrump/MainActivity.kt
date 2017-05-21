package com.tristan.dailytrump

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.tristan.dailytrump.Fragments.HomeFragment
import com.tristan.dailytrump.Fragments.StatementsFragment
import com.tristan.dailytrump.Fragments.TwitterFragment

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val frag: Fragment
        when (item.itemId) {
            R.id.navigation_home -> {
                frag = HomeFragment.newInstance();
                val ft = supportFragmentManager.beginTransaction()
                ft.add(R.id.fragmentContainer, frag, frag.tag)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                frag = TwitterFragment.newInstance();
                val ft = supportFragmentManager.beginTransaction()
                ft.add(R.id.fragmentContainer, frag, frag.tag)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                frag = StatementsFragment.newInstance();
                val ft = supportFragmentManager.beginTransaction()
                ft.add(R.id.fragmentContainer, frag, frag.tag)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
