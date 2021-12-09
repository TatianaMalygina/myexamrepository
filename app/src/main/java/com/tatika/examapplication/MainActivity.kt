package com.tatika.examapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"
private  var CATALOG_FRAGMENT = CatalogFragment().javaClass.name
private var ABOUT_FRAGMENT = AboutFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.catalog -> {
                    fragment = if (savedInstanceState != null)
                        supportFragmentManager.getFragment(savedInstanceState, CATALOG_FRAGMENT)
                    else CatalogFragment()
                }
                R.id.about -> {
                    fragment = if (savedInstanceState != null)
                        supportFragmentManager.getFragment(savedInstanceState, ABOUT_FRAGMENT)
                    else AboutFragment()
                }
            }
                    replaceFragment(fragment!!)
                    true
                }
                bottomNavigationView.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM)?:
                        R.id.catalog
            }

            override fun onSaveInstanceState(outState: Bundle) {
                super.onSaveInstanceState(outState)
                outState.putInt(LAST_SELECTED_ITEM,bottomNavigationView.selectedItemId)
            }
            private fun replaceFragment(fragment: Fragment) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit()
            }
}