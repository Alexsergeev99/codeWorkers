package ru.code.codeworkers.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.code.codeworkers.dto.Worker

@Entity
data class WorkerEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val position: String
    ) {

    fun toDto() = Worker(id, name, position)

    companion object {
        fun fromDto(worker: Worker) = WorkerEntity(
            id = worker.id,
            name = worker.name,
            position = worker.position
        )
    }
}