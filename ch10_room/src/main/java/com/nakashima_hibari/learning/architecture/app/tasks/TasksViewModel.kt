package com.nakashima_hibari.learning.architecture.app.tasks

import androidx.lifecycle.*
import com.nakashima_hibari.learning.architecture.app.data.Task
import com.nakashima_hibari.learning.architecture.app.Event
import kotlinx.coroutines.launch
import com.nakashima_hibari.learning.architecture.app.R
import com.nakashima_hibari.learning.architecture.app.data.source.DefaultTasksRepository
import com.nakashima_hibari.learning.architecture.app.data.source.TasksRepository

/**
 * MVVMパターンのViewModelに該当するクラス
 * */
class TasksViewModel(
    private val tasksRepository: TasksRepository
) : ViewModel() {

    private val _items = MutableLiveData<List<Task>>().apply { value = emptyList() }
    val items: LiveData<List<Task>> = _items

    private val _snackbarText = MutableLiveData<Event<Int>>()
    val snackbarText: LiveData<Event<Int>> = _snackbarText

    private val _openTaskEvent = MutableLiveData<Event<String>>()
    val openTaskEvent: LiveData<Event<String>> = _openTaskEvent

    /**
     * データベースからデータを取得しているという疑似的な処理
     * */
    fun loadTasks() {
        _items.value = listOf(
            Task("title01", "description01"),
            Task("title02", "description02", true),
            Task("title03", "description03"),
            Task("title04", "description04", true),
            Task("title05", "description05"),
            Task("", "description06", true),
            Task("", "description07"),
            Task("", "description08", true),
            Task("", "description09"),
            Task("", "description10"),
            Task("title11", "description11"),
            Task("title12", "description12", true),
            Task("title13", "description13"),
            Task("title14", "description14", true),
            Task("title15", "description15"),
            Task("", "description16", true),
            Task("", "description17"),
            Task("", "description18", true),
            Task("", "description19"),
            Task("", "description20")
        )
    }

    /**
     * リストにデータが何もない状態であるか判定する
     * */
    val empty: LiveData<Boolean> = Transformations.map(_items) {
        it.isEmpty()
    }

    fun completeTask(task: Task, completed: Boolean) = viewModelScope.launch {
        if (completed) {
            tasksRepository.completeTask(task)
            showSnackbarMessage(R.string.task_marked_complete)
        } else {
            tasksRepository.activateTask(task)
            showSnackbarMessage(R.string.task_marked_active)
        }
    }

    /**
     * Called by Data Binding.
     */
    fun openTask(taskId: String) {
        _openTaskEvent.value =
            Event(taskId)
    }

    /**
     * スナックバーを表示
     * */
    private fun showSnackbarMessage(message: Int) {
        _snackbarText.value =
            Event(message)
    }
}