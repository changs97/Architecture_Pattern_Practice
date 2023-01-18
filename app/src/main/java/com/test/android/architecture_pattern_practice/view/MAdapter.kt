package com.test.android.architecture_pattern_practice.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.android.architecture_pattern_practice.R
import com.test.android.architecture_pattern_practice.model.Person


class MAdapter(private var dataList: List<Person>) : RecyclerView.Adapter<MViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return MViewHolder(view)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.name.text = dataList[position].name
        holder.age.text = dataList[position].age.toString()
    }

    override fun getItemCount() = dataList.size

    fun setDataList(newDataList: List<Person>) {
        dataList = newDataList
        notifyDataSetChanged()
    }
}