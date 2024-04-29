package ru.code.codeworkers.model

import ru.code.codeworkers.dto.Worker

data class FeedModel(
    var workers: List<Worker> = emptyList(),
    var loading: Boolean = false,
    var error: Boolean = false,
    var empty: Boolean = false
)