package com.test.android.architecture_pattern_practice.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.test.android.architecture_pattern_practice.R

class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView
    val age: TextView


    init {
        name = itemView.findViewById(R.id.item_name)
        age = itemView.findViewById(R.id.item_age)
    }
}