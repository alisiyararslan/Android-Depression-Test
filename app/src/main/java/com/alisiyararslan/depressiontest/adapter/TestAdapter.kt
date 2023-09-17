package com.alisiyararslan.depressiontest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alisiyararslan.depressiontest.databinding.RecyclerRowTextResultBinding
import com.alisiyararslan.depressiontest.model.Test

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
        holder.binding.recyclerViewTextView.text=testList.get(position).date.toString() +" "+ testList.get(position).testScore.toString()


    }
}