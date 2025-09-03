package com.example.listofhistoricalfigures


import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


internal class MainActivity : AppCompatActivity()
{
    // Нельзя использовать val и var
    private lateinit var observerLifecycle: MyObserverLifecycle

    // Инициализируем ленивым способом
    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observerLifecycle = MyObserverLifecycle()
        // Подписка на события жизненного цикла
        lifecycle.addObserver(observerLifecycle)

        // Инициализируем адаптер и присваеваем его Recycle View
        val adapter = UserAdapter()
        val userList = findViewById<RecyclerView>(R.id.userList)
        userList.layoutManager = LinearLayoutManager(this)
        userList.adapter = adapter

        // Подписываем адаптер на изменение списка
        userViewModel.getListUsers().observe(this, Observer
        {
            it.let {
                adapter.refreshUsers(it)
            }
        })
    }


    // Создание меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    // Обработчик нажатий на меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.refresh -> userViewModel.updateListUsers()
        }

        return super.onOptionsItemSelected(item)
    }
}