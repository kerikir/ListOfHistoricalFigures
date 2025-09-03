package com.example.listofhistoricalfigures

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


// Получение данных из списка
internal class UserViewModel : ViewModel()
{
    // Live Data - паттерн Observer
    private var userList: MutableLiveData<List<User>> = MutableLiveData<List<User>>()

    // Инициализация списка и заполнение начальными данными
    init
    {
        userList.value = DataUsers.getUsers()
    }

    /** Возврат списка пользователей */
    fun getListUser() : MutableLiveData<List<User>> = userList

    // Получение полного списка пользователей
    fun updateListUsers()
    {
        userList.value = DataUsers.getAnotherUsers()
    }
}