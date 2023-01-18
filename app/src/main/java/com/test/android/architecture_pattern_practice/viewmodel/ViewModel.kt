package com.test.android.architecture_pattern_practice.viewmodel

import androidx.databinding.BaseObservable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.test.android.architecture_pattern_practice.model.DataBase
import com.test.android.architecture_pattern_practice.model.Person

class ViewModel(private val dataBase: DataBase) : BaseObservable() {
    val personList = ArrayList<Person>()

    fun loadPersonList() {
        personList.clear()
        personList.addAll(dataBase.getPersonList())
        notifyChange()
    }

    fun shufflePersonList() {
        dataBase.shufflePersonList()
        loadPersonList()
    }

    fun addPerson(name: String, age: Int) {
        val person = Person(name, age)
        dataBase.addPerson(person)
        loadPersonList()
    }

    fun removeAllPerson() {
        dataBase.removePerson()
        loadPersonList()
    }
}