package com.example.todo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "desc") val description: String
)