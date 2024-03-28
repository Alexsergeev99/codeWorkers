package ru.code.codeworkers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.code.codeworkers.databinding.WorkersListBinding
import ru.code.codeworkers.dto.Worker

class WorkersAdapter: ListAdapter<Worker, WorkersViewHolder>(WorkerDifCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkersViewHolder {
        val binding = WorkersListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class WorkersViewHolder (
    private  val binding: WorkersListBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(worker: Worker) {
        binding.apply {

        }
    }
}


object  WorkerDifCallBack: DiffUtil.ItemCallback<Worker>() {
    override fun areItemsTheSame(oldItem: Worker, newItem: Worker) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Worker, newItem: Worker) = oldItem == newItem

}