package com.bestbuy.app

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bestbuy.core.navigation.Navigation
import com.bestbuy.core.view.BaseActivity

/**
 *
 */
class MainActivity :  BaseActivity(){

    private lateinit var navHostFragment: Fragment
    private lateinit var navView: BottomNavigationView

    override val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)!!

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)

        navView.setOnNavigationItemSelectedListener {
            navController.popBackStack()
            when (it.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
                }
                R.id.navigation_products -> {
                    navController.navigate(R.id.navigation_products)
                }
                R.id.navigation_drops -> {
                    navController.navigate(R.id.navigation_drops)
                }
                R.id.navigation_account -> {
                    navController.navigate(R.id.navigation_account)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }

    override fun navigate(screenName: String, bundle: Bundle) {
        when (screenName) {
            Navigation.ScreenName.PRODUCT_DETAILS -> {
                //Can be use case of Deep links
                /*findNavController(R.id.nav_host_fragment_activity_main).navigate(
                    R.id.nav_details, bundle
                )*/
            }
        }
    }

    override fun hideBottomNav() {
    }

    override fun showBottomNav() {
    }
}