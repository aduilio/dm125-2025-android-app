package com.aduilio.mytasks.adapter

import androidx.recyclerview.widget.RecyclerView
import com.aduilio.mytasks.databinding.ListItemBinding
import com.aduilio.mytasks.entity.Task

class ItemViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setData(task: Task) {
        binding.tvTitle.text = task.title
        binding.tvDate.text = task.date
    }
}