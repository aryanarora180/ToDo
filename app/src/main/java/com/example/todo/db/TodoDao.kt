package com.example.todo.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<Todo>

    @Insert
    fun insertTodo(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}