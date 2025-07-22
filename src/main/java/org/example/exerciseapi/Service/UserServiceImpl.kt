package org.example.exerciseapi.Service

import org.example.exerciseapi.Domain.User
import org.example.exerciseapi.Repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserInterface {
    override fun createUser(username: String): User {
        return try {
            this.userRepository.save(User(username = username))
        } catch (e: Exception){
            throw RuntimeException("User with username $username cannot be created")
        }
    }

    override fun getUsers(): List<User> {

            return this.userRepository.findAll()
    }

    override fun getUserbyId(id: UUID): User {
        return this.userRepository.findByIdOrNull(id)?: throw RuntimeException("User with id $id not found")
        }


}