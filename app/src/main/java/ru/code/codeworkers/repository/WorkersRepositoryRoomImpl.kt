package ru.code.codeworkers.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.room.Dao
import ru.code.codeworkers.dao.WorkerDao
import ru.code.codeworkers.dto.Worker

class WorkersRepositoryRoomImpl(
    private  val dao: WorkerDao
) : WorkersRepository {

    private var workers = listOf<Worker>(
        Worker(1, "Alex Sergeev", "Boss"),
        Worker(2, "Sergey Sergeev", "Lawyer")
    )

    override fun getAll(): LiveData<List<Worker>> = dao.getAll().map { list->
        list.map { it.toDto() }
    }

}