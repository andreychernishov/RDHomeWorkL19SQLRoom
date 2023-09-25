package com.example.rdhomeworkl19sqldatabaseroom.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rdhomeworkl19sqldatabaseroom.R
import com.example.rdhomeworkl19sqldatabaseroom.database.TaskEntity

class TaskEntityListAdapter(private var items: List<TaskEntity> = emptyList()) : RecyclerView.Adapter<TaskEntityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskEntityViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return TaskEntityViewHolder(listItemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TaskEntityViewHolder, position: Int) {
        holder.taskName. text = items[position].taskName
        holder.taskDescription.text = items[position].taskDescription
    }

    fun updateItems(itemsToUpdate: List<TaskEntity>){
        items = itemsToUpdate
        notifyDataSetChanged()
    }
}

class TaskEntityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val taskName: TextView = itemView.findViewById(R.id.task_tv)
    val taskDescription: TextView = itemView.findViewById(R.id.description_tv)
}