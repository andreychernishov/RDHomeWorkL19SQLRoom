package com.example.rdhomeworkl19sqldatabaseroom.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.rdhomeworkl19sqldatabaseroom.database.MyApplication
import com.example.rdhomeworkl19sqldatabaseroom.database.TaskEntity

class TaskViewModel: ViewModel() {
    private val repository = MyApplication.getApp().repository
    private val _listState = MutableLiveData<ListState>(ListState.EmptyList)

    val listState: LiveData<ListState> = _listState
    private val observer = Observer<List<TaskEntity>>{
        _listState.postValue(ListState.UpdateList(list = it))
    }
    init {
        repository.getAll().observeForever(observer)
    }
    fun add(taskName: String, taskDescription: String){
        repository.add(TaskEntity(taskName= taskName, taskDescription = taskDescription))
    }
    fun delete(taskEntity: TaskEntity){
        repository.remove(taskEntity)
    }
    override fun onCleared() {
        super.onCleared()
        repository.getAll().removeObserver(observer)
    }
    sealed class ListState{
        object EmptyList: ListState()
        class UpdateList(val list:List<TaskEntity>): ListState()

    }
}