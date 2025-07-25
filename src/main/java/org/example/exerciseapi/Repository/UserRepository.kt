package org.example.exerciseapi.Repository

import org.example.exerciseapi.Domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository: JpaRepository<User, UUID> {
}