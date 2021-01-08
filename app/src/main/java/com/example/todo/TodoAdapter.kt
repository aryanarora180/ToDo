package com.example.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemRowTodoBinding
import com.example.todo.db.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    lateinit var deleteListener: (Todo) -> Unit

    var data = listOf<Todo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRowTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo = data[position]

        with(holder.binding) {
            titleText.text = todo.title
            descriptionText.text = todo.description

            deleteImage.setOnClickListener { deleteListener(todo) }
        }
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(val binding: ItemRowTodoBinding) : RecyclerView.ViewHolder(binding.root)
}