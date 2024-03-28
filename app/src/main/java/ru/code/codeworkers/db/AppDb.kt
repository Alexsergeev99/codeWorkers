package ru.code.codeworkers.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.code.codeworkers.dao.WorkerDao
import ru.code.codeworkers.entity.WorkerEntity

@Database(entities = [WorkerEntity::class], version = 1)
abstract class AppDb: RoomDatabase() {

    abstract val workerDao: WorkerDao

    companion object {
        @Volatile
        private var instance: AppDb? = null

        fun getInstance(context: Context) : AppDb {
         return instance ?: synchronized(this) {
             instance ?: buildDatabase(context).also { instance = it }
         }
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db").
            allowMainThreadQueries().
            build()
    }
}