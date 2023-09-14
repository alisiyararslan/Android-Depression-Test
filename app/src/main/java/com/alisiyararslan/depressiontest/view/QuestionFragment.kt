package com.alisiyararslan.depressiontest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.NavHostFragment
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.databinding.FragmentHomeBinding
import com.alisiyararslan.depressiontest.databinding.FragmentQuestionBinding
import kotlinx.android.synthetic.main.fragment_question.*


class QuestionFragment : Fragment() {

    private var _binding: FragmentQuestionBinding? = null

    private val binding get() = _binding!!

    private var currentQuestion : Int = 1

    private var totalScore : Int = 0

    private var questionList = ArrayList<String>()

    private var lastQuestionScore : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questionList.add("Feeling sad or down in the dumps")
        questionList.add("Feeling unhappy or blue")
        questionList.add("Crying spells or tearfulness")
        questionList.add("Feeling discouraged")
        questionList.add("Feeling hopeless")
        questionList.add("Low self-esteem")
        questionList.add("Feeling worthless or inadequate")
        questionList.add("Guilt or shame")
        questionList.add("Criticizing yourself or others")
        questionList.add("Difficulty making decisions")
        questionList.add("Loss of interest in family, friends or colleagues")
        questionList.add("Loneliness")
        questionList.add("Spending less time with family or friends")
        questionList.add("Loss of motivation")
        questionList.add("Loss of interest in work or other activities")
        questionList.add("Avoiding work or other activities")
        questionList.add("Loss of pleasure or satisfaction in life")
        questionList.add("Feeling tired")
        questionList.add("Difficulty sleeping or sleeping too much")
        questionList.add("Decreased or increased appetite")
        questionList.add("Loss of interest in sex")
        questionList.add("Worrying about your health")
        questionList.add("Do you have any suicidal thoughts?")
        questionList.add("Would you like to end your life?")
        questionList.add("Do you have a plan for harming yourself?")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)


        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionCountTextView.setText((currentQuestion).toString())
        qustionTextView.setText(questionList.get(currentQuestion-1))

        if (currentQuestion==1){
            previousQuestionButton.visibility = View.INVISIBLE
        }





        notAttAllButton.setOnClickListener {
            questionButtonClicked()
            notAttAllButtonClicked()
        }

        somewhatButton.setOnClickListener {
            questionButtonClicked()
            somewhatButtonClicked()
        }

        moderatelyButton.setOnClickListener {
            questionButtonClicked()
            moderatelyButtonClicked()
        }

        aLotButton.setOnClickListener {
            questionButtonClicked()
            aLotButtonClicked()
        }

        extremelyButton.setOnClickListener {
            questionButtonClicked()
            extremelyButtonClicked()
        }

        previousQuestionButton.setOnClickListener {
            questionButtonClicked()
            previousQuestionButtonClicked()
        }
    }



    private fun previousQuestionButtonClicked() {
        currentQuestion -= 2

        questionCountTextView.setText((currentQuestion).toString())
        qustionTextView.setText(questionList.get(currentQuestion-1))

        previousQuestionButton.visibility = View.INVISIBLE
        totalScore -= lastQuestionScore

        if (lastQuestionScore == 0){
            notAttAllButton.setBackgroundResource(R.drawable.custom_button2)
        }else if (lastQuestionScore == 1){
            somewhatButton.setBackgroundResource(R.drawable.custom_button2)
        }else if (lastQuestionScore == 2){
            moderatelyButton.setBackgroundResource(R.drawable.custom_button2)
        }else if (lastQuestionScore == 3){
            aLotButton.setBackgroundResource(R.drawable.custom_button2)
        }else if (lastQuestionScore == 4){
            extremelyButton.setBackgroundResource(R.drawable.custom_button2)
        }
    }

    private fun questionButtonClicked() {
        currentQuestion += 1

        if (currentQuestion == 26){
            var alert = AlertDialog.Builder(requireContext())
            alert.setTitle("TEST COMPLETED")
            alert.setMessage("Congratulations on taking care of your mental health - very few people, only the conscious ones, do. \n\n" +
                    "Curious about your results?")

            alert.setPositiveButton("I'm curious"){dialog,which ->

                var navController = NavHostFragment.findNavController(this)
                val action=QuestionFragmentDirections.actionQuestionFragmentToResultsFragment()

                navController.navigate(action)
            }
            alert.show()
            return
        }

        questionCountTextView.setText((currentQuestion).toString())
        qustionTextView.setText(questionList.get(currentQuestion-1))

        notAttAllButton.setBackgroundResource(R.drawable.custom_button)
        somewhatButton.setBackgroundResource(R.drawable.custom_button)
        moderatelyButton.setBackgroundResource(R.drawable.custom_button)
        aLotButton.setBackgroundResource(R.drawable.custom_button)
        extremelyButton.setBackgroundResource(R.drawable.custom_button)

        previousQuestionButton.visibility = View.VISIBLE
    }

    private fun notAttAllButtonClicked() {

        totalScore += 0
        lastQuestionScore = 0

    }
    private fun somewhatButtonClicked() {

        totalScore += 1
        lastQuestionScore = 1

    }
    private fun moderatelyButtonClicked() {

        totalScore += 2
        lastQuestionScore = 2

    }
    private fun aLotButtonClicked() {
        totalScore += 3
        lastQuestionScore = 3

    }
    private fun extremelyButtonClicked() {
        totalScore += 4
        lastQuestionScore = 4

    }












}