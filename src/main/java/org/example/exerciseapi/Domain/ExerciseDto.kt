package org.example.exerciseapi.Domain

import java.time.LocalDate

data class ExerciseDto(
    val username: String,
    val description: String,
    val duration: Long,
    val date: LocalDate,
    val id: Long
)
