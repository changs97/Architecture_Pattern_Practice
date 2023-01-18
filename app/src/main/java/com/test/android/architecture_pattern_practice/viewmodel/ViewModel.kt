package com.test.android.architecture_pattern_practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.android.architecture_pattern_practice.model.DataBase
import com.test.android.architecture_pattern_practice.model.Person

class ViewModel(private val dataBase: DataBase) {
    private val _personList = MutableLiveData<ArrayList<Person>>()
    val personList: LiveData<ArrayList<Person>> get() = _personList

    fun loadPersonList(): ArrayList<Person> {
        val dataSet = dataBase.getPersonList()
        _personList.value = dataSet
        return dataSet
    }

    fun shufflePersonList() {
        dataBase.shufflePersonList()
        _personList.value = dataBase.getPersonList()
    }

    fun addPerson(name: String, age: Int) {
        val person = Person(name, age)
        dataBase.addPerson(person)
        _personList.value = dataBase.getPersonList()
    }

    fun removeAllPerson() {
        dataBase.removePerson()
        _personList.value = dataBase.getPersonList()

    }
}