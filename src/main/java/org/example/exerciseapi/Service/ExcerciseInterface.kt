package org.example.exerciseapi.Service

import org.example.exerciseapi.Domain.ExerciseDto
import org.example.exerciseapi.Domain.Logs
import java.time.LocalDate
import java.util.UUID

interface ExcerciseInterface {
    fun createExercise(id: UUID,description: String,duration: Long,exerciseDate: LocalDate): ExerciseDto
    fun getLogs(id: UUID): Logs
}