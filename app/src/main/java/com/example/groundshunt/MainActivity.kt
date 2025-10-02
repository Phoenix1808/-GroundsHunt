package com.yourpackage.groundshunt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.groundshunt.DashboardFragment
import com.example.groundshunt.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()
    private val searchFragment = SearchFragment()
    private val profileFragment = ProfileFragment()
    private val bookingsFragment = BookingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)


        if (savedInstanceState == null) {
            setCurrentFragment(searchFragment)
            bottomNav.selectedItemId = R.id.nav_search
        }


        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    setCurrentFragment(dashboardFragment)
                    true
                }
                R.id.nav_search -> {
                    setCurrentFragment(searchFragment)
                    true
                }
                R.id.nav_profile -> {
                    setCurrentFragment(profileFragment)
                    true
                }
                R.id.nav_menu -> {
                    setCurrentFragment(bookingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            setReorderingAllowed(true)
        }
    }
}
