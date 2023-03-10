package com.test.android.architecture_pattern_practice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.android.architecture_pattern_practice.MainContract
import com.test.android.architecture_pattern_practice.R
import com.test.android.architecture_pattern_practice.databinding.ActivityMainBinding
import com.test.android.architecture_pattern_practice.model.DataBase
import com.test.android.architecture_pattern_practice.model.Person
import com.test.android.architecture_pattern_practice.presenter.Presenter

class MainActivity : AppCompatActivity(), MainContract.View {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: MAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val presenter = Presenter(this, DataBase())

        adapter = MAdapter(presenter.loadPersonList())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.add.setOnClickListener {
            try {
                val name = binding.name.text.toString()
                val age = binding.age.text.toString().toInt()
                presenter.addPerson(name, age)
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }

            binding.name.text.clear()
            binding.age.text.clear()
        }

        binding.remove.setOnClickListener {
            presenter.removeAllPerson()
        }

        binding.shuffle.setOnClickListener {
            presenter.shufflePersonList()
        }
    }

    override fun showPersonList(personList: ArrayList<Person>) {
        adapter.setDataList(personList)
    }
}