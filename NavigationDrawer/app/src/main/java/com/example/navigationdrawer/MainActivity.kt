package com.example.navigationdrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationdrawer.databinding.ActivityMainWithNavDrawerBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener,
NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainWithNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.img1.setOnClickListener { }
        binding.img2.setOnClickListener { }
        binding.img3.setOnClickListener { }
        binding.img4.setOnClickListener { }
        binding.img5.setOnClickListener { }
        binding.img6.setOnClickListener { }

        setSupportActionBar(binding.navToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var toggleOnOff = ActionBarDrawerToggle(this, binding.drawerLayout, binding.navToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggleOnOff)
        toggleOnOff.syncState()
        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val intent = Intent(this, EmailActivity::class.java)
        when(p0.itemId){
            R.id.nav_profile -> Toast.makeText(this, "Click on profile", Toast.LENGTH_SHORT).show()
            R.id.nav_email -> startActivity(intent)

        }
        return true
    }
}