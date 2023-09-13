package com.alisiyararslan.depressiontest.view

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.databinding.FragmentHomeBinding
import com.alisiyararslan.depressiontest.databinding.FragmentTestBinding
import kotlinx.android.synthetic.main.fragment_test.*


class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val sourceString = "<b>Instructions:</b> Choose option to indicate how much you have experienced each symptom during the past week, including to day. Please answer all 25 items."

        //binding.testFragmentInstructionTextView.setText(Html.fromHtml(sourceString))






    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)


        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testFragmentStartTestButton.setOnClickListener {
            //val action=TestFragmentDirections.actionTestFragmentToQuestionFragment()
            //Navigation.findNavController(it).navigate(action)

            var navController = NavHostFragment.findNavController(this)
            val action=TestFragmentDirections.actionTestFragmentToQuestionFragment()
            navController.navigate(action)
        }
    }


}