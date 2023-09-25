package com.example.rdhomeworkl19sqldatabaseroom.database

import java.util.concurrent.Executors

class Repository(private val database: DataBase) {

    private val executor = Executors.newSingleThreadExecutor()

    fun getAll() = database.taskDao().getAllTasks()

    fun add(taskEntity: TaskEntity){
        executor.execute{
            database.taskDao().addTask(taskEntity)
        }
    }
    fun remove(taskEntity: TaskEntity){
        executor.execute {
            database.taskDao().deleteTask(taskEntity)
        }
    }
}