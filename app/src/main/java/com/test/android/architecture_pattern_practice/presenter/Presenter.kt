package com.test.android.architecture_pattern_practice.presenter

import com.test.android.architecture_pattern_practice.MainContract
import com.test.android.architecture_pattern_practice.model.DataBase
import com.test.android.architecture_pattern_practice.model.Person

class Presenter(private val view: MainContract.View, private val dataBase: DataBase) : MainContract.Presenter {

    override fun loadPersonList(): ArrayList<Person> {
        return dataBase.getPersonList()
    }

    override fun shufflePersonList() {
        dataBase.shufflePersonList()
        view.showPersonList(dataBase.getPersonList())
    }

    override fun addPerson(person: Person) {
        dataBase.addPerson(person)
        view.showPersonList(dataBase.getPersonList())
    }

    override fun removeAllPerson() {
        dataBase.removePerson()
        view.showPersonList(dataBase.getPersonList())
    }
}