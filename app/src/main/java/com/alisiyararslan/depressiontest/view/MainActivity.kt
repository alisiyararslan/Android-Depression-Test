package com.alisiyararslan.depressiontest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragmentManager=supportFragmentManager
    private val fragmentTransaction=fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun homeButtonClicked(view : View){

        var navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        navController.navigate(R.id.homeFragment)
    }

    fun testButtonClicked(view : View){

        var navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        navController.navigate(R.id.testFragment)

    }

    fun resultsButtonClicked(view : View){

        var navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        navController.navigate(R.id.resultsFragment)

    }
}