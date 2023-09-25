package com.example.rdhomeworkl19sqldatabaseroom.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val taskName: String,
    val taskDescription: String
)
