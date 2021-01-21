package com.example.android.navbarbotchip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.android.navbarbotchip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //stops from going into night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setUpTabBar()

    }

    private fun setUpTabBar(){
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it){
                R.id.nav_near -> binding.textMain.text = "Nearby"
                R.id.nav_message -> binding.textMain.text = "Message"
                R.id.nav_profile -> {
                    binding.textMain.text = "Profile"
                    //add a red badge when profile is clicked
                    binding.bottomNavBar.showBadge(R.id.nav_settings)
                }
                R.id.nav_settings -> {
                    binding.textMain.text = "Settings"
                    //removes the red badge
                    binding.bottomNavBar.dismissBadge(R.id.nav_settings)
                }
            }
        }
    }


}