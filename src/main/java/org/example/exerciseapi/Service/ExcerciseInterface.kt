package org.example.exerciseapi.Service

import org.example.exerciseapi.Domain.Exercise
import org.example.exerciseapi.Domain.ExerciseDto
import org.example.exerciseapi.Domain.Logs
import org.springframework.http.ResponseEntity
import java.time.LocalDate
import java.util.Date
import java.util.Locale
import java.util.UUID

interface ExcerciseInterface {
    fun createExercise(id: UUID,description: String,duration: Long,exerciseDate: LocalDate): ExerciseDto
    fun getLogs(id: UUID): Logs
}