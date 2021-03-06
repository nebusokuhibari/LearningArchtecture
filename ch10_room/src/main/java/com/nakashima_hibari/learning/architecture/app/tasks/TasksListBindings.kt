package com.nakashima_hibari.learning.architecture.app.tasks

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nakashima_hibari.learning.architecture.app.data.Task

/**
 * リストUIにコレクションをバインドするためのメソッド
 * BindingAdapter属性を付与することにより、
 * layoutファイル上で「app:items="@{viewmodel.items}"」のように記述するだけでバインドできる
 * */
@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Task>) {
    (listView.adapter as TasksAdapter).submitList(items)
}

@BindingAdapter("app:completedTask")
fun setStyle(textView: TextView, enabled: Boolean) {
    if (enabled) {
        textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}