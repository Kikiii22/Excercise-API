package org.example.exerciseapi.Domain

import java.util.UUID

data class Logs (val username: String,
                 val count: Int,
                 val id: UUID,
                 val log: List<LogEntry>)