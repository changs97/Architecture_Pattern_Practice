package com.test.android.architecture_pattern_practice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.android.architecture_pattern_practice.databinding.ActivityMainBinding
import com.test.android.architecture_pattern_practice.model.DataBase
import com.test.android.architecture_pattern_practice.model.Person
import com.test.android.architecture_pattern_practice.viewmodel.ViewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: MAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val viewModel = ViewModel(DataBase())

        viewModel.personList.observe(this) {
            adapter.setDataList(it)
        }

        adapter = MAdapter(viewModel.loadPersonList())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.add.setOnClickListener {
            try {
                val name = binding.name.text.toString()
                val age = binding.age.text.toString().toInt()
                viewModel.addPerson(name, age)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }

            binding.name.text.clear()
            binding.age.text.clear()
        }

        binding.remove.setOnClickListener {
            viewModel.removeAllPerson()
        }

        binding.shuffle.setOnClickListener {
            viewModel.shufflePersonList()
        }
    }
}