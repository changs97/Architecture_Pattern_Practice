package com.test.android.architecture_pattern_practice.model

class DataBase {
    private val personList = ArrayList<Person>()

    fun getPersonList(): ArrayList<Person> = personList

    fun addPerson(person: Person) {
        personList.add(person)
    }

    fun removePerson() {
        personList.clear()
    }

    fun shufflePersonList() {
        personList.shuffle()
    }
}