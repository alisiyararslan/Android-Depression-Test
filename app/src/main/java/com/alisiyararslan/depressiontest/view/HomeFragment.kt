package com.alisiyararslan.depressiontest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFragmentHome.setOnClickListener {
            val action=HomeFragmentDirections.actionHomeFragmentToTestFragment()
            Navigation.findNavController(it).navigate(action)

            //Navigation.findNavController(view).navigate(R.id.testFragment)
        }
    }


}