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

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()

        val homeFragment=HomeFragment()
        fragmentTransaction.replace(R.id.fragmentContainerView,homeFragment).commit()
    }

    fun testButtonClicked(view : View){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        val testFragment=TestFragment()
        fragmentTransaction.replace(R.id.fragmentContainerView,testFragment).commit()

        //Navigation.findNavController(view).navigate(R.id.testFragment)


    }

    fun resultsButtonClicked(view : View){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        val resultsFragment=ResultsFragment()
        fragmentTransaction.replace(R.id.fragmentContainerView,resultsFragment).commit()

    }
}