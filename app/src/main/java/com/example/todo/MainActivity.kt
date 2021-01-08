package com.example.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.db.TodoDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: TodoDatabase

    private val todoAdapter = TodoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = TodoDatabase.getDatabase(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter.deleteListener = { db.todoDao().delete(it) }
        db.todoDao().getAll().observe(this) {
            todoAdapter.data = it
        }

        binding.todoRecycler.adapter = todoAdapter

        binding.floatingActionButton.setOnClickListener {
            startActivity(Intent(this, AddTodoActivity::class.java))
        }
    }
}