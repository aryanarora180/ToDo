package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todo.databinding.ActivityAddTodoBinding
import com.example.todo.db.Todo
import com.example.todo.db.TodoDatabase
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext

class AddTodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTodoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            TodoDatabase.getDatabase(this).todoDao().insertTodo(Todo(
                title = binding.titleInputEditText.text.toString(),
                description = binding.descriptionEditText.text.toString()
            ))
            finish()
        }
    }
}