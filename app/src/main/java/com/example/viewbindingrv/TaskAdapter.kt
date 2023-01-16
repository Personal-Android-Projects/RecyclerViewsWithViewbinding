package com.example.viewbindingrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingrv.databinding.ItemLayoutBinding

class TaskAdapter(val taskList : List<Task>) :RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){
    //Bind layout elements with corresponding data items
    inner class TaskViewHolder(val itemBinding:ItemLayoutBinding):RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(task : Task){
            itemBinding.title.text = task.title
            itemBinding.time.text = task.timeStamp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    //This is where the actual binding takes place{Of layout elements and data}
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        //Get the right data item based on its position
        val task = taskList[position]
        //Bind data to layout element
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}