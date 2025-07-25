package org.example.exerciseapi.Api

import org.example.exerciseapi.Domain.User
import org.example.exerciseapi.Service.ExcerciseServiceImpl
import org.example.exerciseapi.Service.UserServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.UUID


@RestController
@RequestMapping("/api")
class Controller(private val service: UserServiceImpl, private val exService: ExcerciseServiceImpl) {
    @PostMapping("/users")
    fun createUser(@RequestParam username: String): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(service.createUser(username))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(service.getUsers())
    }

    @GetMapping("/users/{id}")
    fun getUserbyId(@PathVariable id: UUID): ResponseEntity<Any> {
        return try {
            return ResponseEntity.ok(service.getUserbyId(id))
        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }

    @PostMapping("/users/{id}/exercises")
    fun createExercise(
        @PathVariable id: UUID,
        @RequestParam description: String, @RequestParam duration: Long,
        @RequestParam(required = false) date: LocalDate?
    ): ResponseEntity<Any> {
        return try {
            val exerciseDate = date ?: LocalDate.now()
            val exercise = exService.createExercise(id, description, duration, exerciseDate)
            ResponseEntity.ok(exercise)

        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)

        }
    }

    @GetMapping("/users/{id}/logs")
    fun getLog(@PathVariable id: UUID,@RequestParam(required = false) from: LocalDate?,
               @RequestParam(required = false) to: LocalDate?,
               @RequestParam(required = false) limit: Int?
               ): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(exService.getLogs(id, from, to, limit))

        } catch (e: Exception) {
            ResponseEntity.badRequest().body(e.message)

        }
    }
}