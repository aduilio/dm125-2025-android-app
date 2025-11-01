package com.aduilio.mytasks.service

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aduilio.mytasks.entity.Task

class TaskService : ViewModel() {

    private val taskRepository = RetrofitService().getTaskRepository()

    fun create(task: Task): LiveData<Task> {
        val taskLiveData = MutableLiveData<Task>()

        taskRepository.create(task).enqueue(ServiceCallBack(taskLiveData))

        return taskLiveData
    }

    fun list(): LiveData<List<Task>> {
        val tasksLiveData = MutableLiveData<List<Task>>()

        taskRepository.list().enqueue(ServiceCallBack(tasksLiveData))

        return tasksLiveData
    }
}