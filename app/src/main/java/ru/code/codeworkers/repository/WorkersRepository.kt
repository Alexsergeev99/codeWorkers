package ru.code.codeworkers.repository

import androidx.lifecycle.LiveData
import ru.code.codeworkers.dto.Worker

interface WorkersRepository {
//fun getAll(): LiveData<List<Worker>>
fun getAll(callback: GetAllCallback)
    interface GetAllCallback{
        fun onSuccess(workers: List<Worker>)
        fun onError(e: Exception)
    }

}