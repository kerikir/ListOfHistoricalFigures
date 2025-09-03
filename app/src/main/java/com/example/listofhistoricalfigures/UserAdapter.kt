package com.example.listofhistoricalfigures

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// Создает список и наполняет данными
internal class UserAdapter: RecyclerView.Adapter<UserAdapter.UserHolder>()
{
    // Описание элементов и привязка к Recycle View
    /** Предоставляет доступ к View элементам */
    class UserHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        // Scope-function
        /** Связывает данные пользователя с элементом интерфейса */
        fun bind(user: User) = with(itemView)
        {
            val tvName: TextView = findViewById(R.id.userName)
            val tvDescriptor: TextView = findViewById(R.id.userDescription)

            tvName.text = user.name
            tvDescriptor.text = user.description
        }
    }


    /** Отображаемые пользователи */
    private var users: List<User> = ArrayList<User>()

    // Создаем View Holder когда это необходимо
    // Создает View Holder и инициализирует View компоненты для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder
    {
        return UserHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.user_item, parent, false))
    }

    override fun getItemCount(): Int
    {
        return users.size
    }

    // Связываем View с содержимым
    override fun onBindViewHolder(viewHolder: UserHolder, position: Int)
    {
        viewHolder.bind(users[position])
    }

    /** Передаем данные и опопвещаем адаптер об обновлении данных списка */
    fun refreshUsers(users: List<User>) : Unit
    {
        this.users = users
        notifyDataSetChanged()
    }
}