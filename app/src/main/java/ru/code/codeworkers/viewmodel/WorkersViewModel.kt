package ru.code.codeworkers.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.code.codeworkers.db.AppDb
import ru.code.codeworkers.dto.Worker
import ru.code.codeworkers.repository.WorkersRepository
import ru.code.codeworkers.repository.WorkersRepositoryRoomImpl

private val empty: Worker = Worker(
    id = 0,
    name = "",
    position = ""
)

class WorkersViewModel(application: Application) : AndroidViewModel(application) {
 private val repository: WorkersRepository = WorkersRepositoryRoomImpl(
     AppDb.getInstance(application).workerDao
 )

    val data = repository.getAll()
    val edited = MutableLiveData(empty)

}