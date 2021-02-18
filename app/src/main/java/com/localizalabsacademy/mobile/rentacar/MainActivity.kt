package com.localizalabsacademy.mobile.rentacar

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    /**
     * It is responsible for control the fragments
     */
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "Starting onCreate...")

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        this.setupActionBarWithNavController(navController)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home ->
                    Toast.makeText(
                        this,
                        "Home",
                        Toast.LENGTH_SHORT
                    ).show()
                R.id.menu_my_reservation ->
                    Toast.makeText(
                        this,
                        "Reservation",
                        Toast.LENGTH_SHORT
                    ).show()
                R.id.menu_profile -> Toast.makeText(
                    this,
                    "Profile",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object {
        private const val TAG = "RENTMainActivity"
    }
}