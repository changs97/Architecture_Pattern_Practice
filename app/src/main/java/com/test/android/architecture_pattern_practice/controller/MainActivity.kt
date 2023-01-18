package com.test.android.architecture_pattern_practice.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.android.architecture_pattern_practice.databinding.ActivityMainBinding
import com.test.android.architecture_pattern_practice.model.DataBase
import com.test.android.architecture_pattern_practice.model.Person
import com.test.android.architecture_pattern_practice.view.MAdapter

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: MAdapter
    private lateinit var dataBase: DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataBase = DataBase()

        adapter = MAdapter(loadPersonList())
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.add.setOnClickListener {
            val name = binding.name.text.toString()
            val age = binding.age.text.toString().toInt()
            val person = Person(name, age)

            addPerson(person)

            binding.name.text.clear()
            binding.age.text.clear()
        }

        binding.remove.setOnClickListener {
            removeAllPerson()
        }

        binding.shuffle.setOnClickListener {
            shufflePersonList()
        }
    }

    private fun loadPersonList(): ArrayList<Person> = dataBase.getPersonList()

    private fun shufflePersonList() {
        dataBase.shufflePersonList()
        showPersonList(dataBase.getPersonList())
    }

    private fun addPerson(person: Person) {
        dataBase.addPerson(person)
        showPersonList(dataBase.getPersonList())
    }

    private fun removeAllPerson() {
        dataBase.removePerson()
        showPersonList(dataBase.getPersonList())
    }

    private fun showPersonList(personList: ArrayList<Person>) {
        adapter.setDataList(personList)
    }
}