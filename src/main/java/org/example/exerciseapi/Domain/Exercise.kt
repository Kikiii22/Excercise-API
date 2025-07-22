package org.example.exerciseapi.Domain

import org.example.exerciseapi.Domain.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.util.Date

@Entity
@Table(name = "exercises")
data class Exercise(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val date: LocalDate =LocalDate.now(),
    val duration: Long=0,
    val description: String="",

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User?=null
)

