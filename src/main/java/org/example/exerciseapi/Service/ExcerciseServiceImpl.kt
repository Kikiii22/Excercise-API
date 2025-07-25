package org.example.exerciseapi.Service

import org.example.exerciseapi.Domain.Exercise
import org.example.exerciseapi.Domain.ExerciseDto
import org.example.exerciseapi.Domain.LogEntry
import org.example.exerciseapi.Domain.Logs
import org.example.exerciseapi.Repository.ExerciseRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.UUID

@Service
class ExcerciseServiceImpl(private val service: UserServiceImpl, private val exRepository: ExerciseRepository) :
    ExcerciseInterface {
    override fun createExercise(
        id: UUID,
        description: String,
        duration: Long,
        exerciseDate: LocalDate
    ): ExerciseDto {
        val user = try {
            this.service.getUserbyId(id)
        } catch (e: Exception) {
            throw RuntimeException("User with id $id not found")
        }
        val saved = this.exRepository.save(
            Exercise(
                description = description,
                duration = duration,
                date = exerciseDate,
                user = user
            )
        )
        return ExerciseDto(
            username = saved.user!!.username,
            description = saved.description,
            duration = saved.duration,
            date = saved.date,
            id = saved.id,
            )

    }

    override fun getLogs(id: UUID, from: LocalDate?, to: LocalDate?, limit: Int?): Logs {
        val user = this.service.getUserbyId(id)
        val userId = user.id ?: throw IllegalStateException("User id is null")
        val exercises = exRepository.findAllByUserId(userId)
        val filtered=exercises.filter { i->
            val exerciseDate=i.date
            (from==null||!exerciseDate.isBefore(from))&&(
                    to==null||!exerciseDate.isAfter(to)
                    )
        }.sortedBy { it.date }.map { it->LogEntry(it.description, it.duration, it.date)
        }.let {
            lista->if (limit!=null) lista.take(limit)
            else lista
        }

        return Logs(user.username, filtered.size, id, filtered)
    }


}