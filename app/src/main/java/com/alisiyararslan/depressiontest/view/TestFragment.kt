package com.alisiyararslan.depressiontest.view

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.databinding.FragmentTestBinding


class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sourceString = "<b>Instructions:</b> Choose option to indicate how much you have experienced each symptom during the past week, including to day. Please answer all 25 items."

        binding.testFragmentInstructionTextView.setText(Html.fromHtml(sourceString))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }


}