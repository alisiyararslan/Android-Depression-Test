package com.alisiyararslan.depressiontest.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.alisiyararslan.depressiontest.databinding.RecyclerRowTextResultBinding
import com.alisiyararslan.depressiontest.model.Test
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class TestAdapter(val testList:ArrayList<Test>): RecyclerView.Adapter<TestAdapter.TestHolder>() {

    class TestHolder (val binding:RecyclerRowTextResultBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val binding=RecyclerRowTextResultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TestHolder(binding)
    }

    override fun getItemCount(): Int {
        return testList.size
    }


    override fun onBindViewHolder(holder: TestHolder, position: Int) {

        val myFormat = "dd-MM-yyyy HH:mm"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)

        holder.binding.recyclerViewTextView.text= "Date: "+sdf.format(testList.get(position).date) +"     Score: "+ testList.get(position).testScore.toString()


    }
}