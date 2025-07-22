package org.example.exerciseapi.Service

import org.example.exerciseapi.Domain.User
import java.util.UUID

interface UserInterface {
    fun createUser(username:String): User
    fun getUsers(): List<User>
    fun getUserbyId(id: UUID): User
}