package com.test.android.architecture_pattern_practice

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.android.architecture_pattern_practice.model.Person
import com.test.android.architecture_pattern_practice.view.MAdapter


@BindingAdapter("items")
fun setItems(recyclerView: RecyclerView, items: List<Person>) {
    val adapter: MAdapter = recyclerView.adapter as MAdapter
    adapter.setDataList(items)
}
