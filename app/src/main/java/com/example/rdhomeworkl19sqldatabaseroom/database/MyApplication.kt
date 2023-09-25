package com.example.rdhomeworkl19sqldatabaseroom.database

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase

class MyApplication: Application() {

    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        instance = this
        val db = Room.databaseBuilder(context = this,
            klass = DataBase::class.java,
            "task_db").build()
        repository = Repository(db)
    }
    companion object{
        private lateinit var instance:MyApplication
        fun getApp() = instance
    }
}