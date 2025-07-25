package org.example.exerciseapi.Domain

import java.time.LocalDate

data class LogEntry(
    val description: String,
    val duration: Long,
    val date: LocalDate)