package com.alisiyararslan.depressiontest.view

import android.graphics.Typeface
import android.icu.lang.UProperty.INT_START
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.alisiyararslan.depressiontest.databinding.FragmentTestBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_test.*


class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)












    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)

        //make a specific text on TextView BOLD
        val str = SpannableStringBuilder("Instructions: Choose option to indicate how much you have experienced each symptom during the past week, including to day. Please answer all 25 items.")
        str.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            14,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.testFragmentInstructionTextView.text = str

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().southMenu.visibility = View.VISIBLE// update south menu visibility

        testFragmentStartTestButton.setOnClickListener {
            //val action=TestFragmentDirections.actionTestFragmentToQuestionFragment()
            //Navigation.findNavController(it).navigate(action)

            var navController = NavHostFragment.findNavController(this)
            val action=TestFragmentDirections.actionTestFragmentToQuestionFragment()
            navController.navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }


}