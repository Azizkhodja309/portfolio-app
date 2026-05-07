package com.azizkhodja.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.azizkhodja.portfolio.databinding.ActivityMainBinding
import com.azizkhodja.portfolio.ui.about.AboutFragment
import com.azizkhodja.portfolio.ui.contact.ContactFragment
import com.azizkhodja.portfolio.ui.home.HomeFragment
import com.azizkhodja.portfolio.ui.projects.ProjectsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            binding.bottomNav.selectedItemId = R.id.nav_home
        }

        binding.bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_about -> AboutFragment()
                R.id.nav_projects -> ProjectsFragment()
                R.id.nav_contact -> ContactFragment()
                else -> return@setOnItemSelectedListener false
            }
            replaceFragment(fragment)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
