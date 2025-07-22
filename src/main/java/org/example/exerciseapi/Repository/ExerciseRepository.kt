package org.example.exerciseapi.Repository

import org.example.exerciseapi.Domain.Exercise
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ExerciseRepository: JpaRepository<Exercise, Long> {
    fun findAllByUserId(userId: UUID): List<Exercise>
}