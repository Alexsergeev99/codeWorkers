package ru.code.codeworkers.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.room.Dao
import ru.code.codeworkers.api.WorkersApi
import ru.code.codeworkers.dao.WorkerDao
import ru.code.codeworkers.dto.Worker

//class WorkersRepositoryRoomImpl(
//    private  val dao: WorkerDao
//) : WorkersRepository {
class WorkersRepositoryRoomImpl: WorkersRepository{
    private var workers = listOf<Worker>(
        Worker(1, "Alex Sergeev", "Boss"),
        Worker(2, "Sergey Sergeev", "Lawyer")
    )


    private  val data = MutableLiveData(workers)
//    override fun getAll(): LiveData<List<Worker>> = data

//    override fun getAll(): LiveData<List<Worker>> = dao.getAll().map { list->
//        list.map { it.toDto() }
//    }

    override fun getAll(callback: WorkersRepository.GetAllCallback) {
        WorkersApi.retrofitService.getAll()
            .enqueue(
                object : retrofit2.Callback<List<Worker>> {

                    override fun onFailure(call: retrofit2.Call<List<Worker>>, t: Throwable) {
                        callback.onError(Exception(t))
                    }

                    override fun onResponse(
                        call: retrofit2.Call<List<Worker>>,
                        response: retrofit2.Response<List<Worker>>
                    ) {
                        if (!response.isSuccessful) {
                            callback.onError(RuntimeException(response.message()))
                            return
                        }
                        val responseBody = response.body() ?: throw Exception("body is null")
                        callback.onSuccess(responseBody)
                    }
                }
            )
    }

}
