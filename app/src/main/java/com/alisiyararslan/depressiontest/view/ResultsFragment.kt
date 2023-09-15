package com.alisiyararslan.depressiontest.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.adapter.TestAdapter
import com.alisiyararslan.depressiontest.databinding.FragmentResultsBinding
import com.alisiyararslan.depressiontest.model.Test
import com.alisiyararslan.depressiontest.roomdb.TestDao
import com.alisiyararslan.depressiontest.roomdb.TestDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_results.*


class ResultsFragment : Fragment() {


    private var _binding: FragmentResultsBinding? = null

    private val binding get() = _binding!!

    private lateinit var db: TestDatabase
    private lateinit var artDao: TestDao

    private var compositeDisposible= CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db= Room.databaseBuilder(requireContext(),TestDatabase::class.java,"Tests").build()
        artDao=db.testDao()

        compositeDisposible.add(
            artDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse)
        )

    }

    fun handleResponse(testList:List<Test>){
        binding.recyclerView.layoutManager= LinearLayoutManager(requireContext())
        val adapter=TestAdapter(ArrayList(testList))
        binding.recyclerView.adapter=adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { // If arguments is not null, execute the following block

            val info=ResultsFragmentArgs.fromBundle(it).infoFromWhere
            if (info.equals("QuestionFragment")){
                resultFragmentTestScoreTextView.visibility = View.VISIBLE
                resultFragmentDepressionLevelTextView.visibility = View.VISIBLE

                var testResult: Int = ResultsFragmentArgs.fromBundle(it).testResult

                resultFragmentTestScoreTextView.text="Most recent test score: " + testResult.toString()
                if (testResult <=5){
                    resultFragmentDepressionLevelTextView.text="Most recent level of depression: " + "No Depression"
                }else if (testResult <=10){
                    resultFragmentDepressionLevelTextView.text="Most recent level of depression: " + "Normal but unhappy"
                }else if (testResult <=25){
                    resultFragmentDepressionLevelTextView.text="Most recent level of depression: " + "Mild depression"
                }else if (testResult <=50){
                    resultFragmentDepressionLevelTextView.text="Most recent level of depression: " + "Moderate depression"
                }else if (testResult <=75){
                    resultFragmentDepressionLevelTextView.text="Most recent level of depression: " + "Severe depression"
                }else{
                    resultFragmentDepressionLevelTextView.text="Most recent level of depression: " + "Extreme depression"
                }

            }else{
                // If arguments is null, execute this block
                resultFragmentTestScoreTextView.visibility = View.GONE
                resultFragmentDepressionLevelTextView.visibility = View.GONE
            }

        }


    }


}