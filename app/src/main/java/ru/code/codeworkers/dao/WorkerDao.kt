package ru.code.codeworkers.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.code.codeworkers.entity.WorkerEntity

@Dao
interface WorkerDao {
  @Query("SELECT * FROM WorkerEntity ORDER BY id DESC")
  fun getAll(): LiveData<List<WorkerEntity>>

    @Insert
    fun insert(worker: WorkerEntity)
}