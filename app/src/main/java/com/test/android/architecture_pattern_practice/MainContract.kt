package com.test.android.architecture_pattern_practice

import com.test.android.architecture_pattern_practice.model.Person

class MainContract {
    interface View {
        fun showPersonList(personList: ArrayList<Person>)
    }

    interface Presenter {
        fun loadPersonList(): ArrayList<Person>
        fun shufflePersonList()
        fun addPerson(person: Person)
        fun removeAllPerson()
    }
}