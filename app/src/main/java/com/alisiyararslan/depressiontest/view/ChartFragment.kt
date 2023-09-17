package com.alisiyararslan.depressiontest.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import com.alisiyararslan.depressiontest.R
import com.alisiyararslan.depressiontest.databinding.FragmentChartBinding
import com.alisiyararslan.depressiontest.databinding.FragmentResultsBinding
import com.alisiyararslan.depressiontest.model.Test
import com.alisiyararslan.depressiontest.roomdb.TestDao
import com.alisiyararslan.depressiontest.roomdb.TestDatabase
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ChartFragment : Fragment() {

    private var _binding: FragmentChartBinding? = null

    private val binding get() = _binding!!

    private lateinit var db: TestDatabase
    private lateinit var artDao: TestDao

    private var compositeDisposible= CompositeDisposable()

    private lateinit var mpLineChart: LineChart


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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    fun handleResponse(testList:List<Test>){
        var entries  =  ArrayList<Entry>()
        mpLineChart = binding.lineChart

        var cnt : Float = 1f
        testList.forEach{
//            dataVals.add(Entry(it.date,it.testScore))
            entries.add(Entry(cnt,(it.testScore).toFloat()))
            cnt+=1f

        }
/*
        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))
        entries.add(Entry(6f, 10f))
        entries.add(Entry(7f, 2f))
        entries.add(Entry(8f, 7f))
        entries.add(Entry(9f, 20f))
        entries.add(Entry(10f, 16f))*/

        val vl = LineDataSet(entries,"My Data" )


        mpLineChart.setBackgroundColor(Color.LTGRAY)
        mpLineChart.setNoDataText("Saved test result not found, solve the test first.")
        mpLineChart.setNoDataTextColor(Color.GREEN)
        mpLineChart.setDrawGridBackground(true)
        mpLineChart.setDrawBorders(true)

        vl.lineWidth = 5f
        vl.color = Color.GREEN
        vl.setDrawCircles(true)
        vl.setDrawCircleHole(false)
        vl.setCircleColor(Color.BLUE)
        vl.circleRadius = 5f
        vl.valueTextSize = 15f
        vl.valueTextColor = Color.BLACK

        var legend : Legend = mpLineChart.legend
        legend.isEnabled =false
        legend.textColor = Color.rgb(15,56,48)
        legend.textSize = 10f
        legend.form = Legend.LegendForm.LINE
        legend.formSize = 20f



        //The text explaining the x-axis in the lower right corner of the chart
        var description : Description = Description()
        description.text = "Date"
        description.textColor = Color.BLACK
        description.textSize = 20f
        mpLineChart.description = description

        mpLineChart.data = LineData(vl)
        mpLineChart.invalidate()
    }


}