package com.example.rdhomeworkl19sqldatabaseroom.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDAO {
    @Insert
    fun addTask(taskEntity: TaskEntity)
    @Delete
    fun deleteTask(taskEntity: TaskEntity)
    @Query("SELECT * FROM tasks")
    fun getAllTasks():LiveData<List<TaskEntity>>
}