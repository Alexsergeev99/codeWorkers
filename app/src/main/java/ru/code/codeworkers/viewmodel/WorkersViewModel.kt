package ru.code.codeworkers.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.code.codeworkers.db.AppDb
import ru.code.codeworkers.dto.Worker
import ru.code.codeworkers.model.FeedModel
import ru.code.codeworkers.repository.WorkersRepository
import ru.code.codeworkers.repository.WorkersRepositoryRoomImpl

private val empty: Worker = Worker(
    id = 0,
    name = "",
    position = ""
)

class WorkersViewModel(application: Application) : AndroidViewModel(application) {
// private val repository: WorkersRepository = WorkersRepositoryRoomImpl(
//     AppDb.getInstance(application).workerDao
// )
private val repository: WorkersRepository = WorkersRepositoryRoomImpl()

    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _data
    val edited = MutableLiveData(empty)

    init {
        load()
    }
    fun load() {
        _data.value = FeedModel(loading = true)

        repository.getAll(object : WorkersRepository.GetAllCallback {
            override fun onSuccess(workers: List<Worker>) {
                _data.value = FeedModel(workers = workers, empty = workers.isEmpty())
            }

            override fun onError(e: Exception) {
//                _errorMessage.value = Unit
                _data.value = FeedModel(error = true)
            }
        })
    }

}