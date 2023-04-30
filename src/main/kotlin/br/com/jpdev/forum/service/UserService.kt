package br.com.jpdev.forum.service

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.model.User
import br.com.jpdev.forum.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class UserService(
        private val userRepository: UserRepository
) {

    fun find(id: Long): User {
        return userRepository.findById(id).get()
    }
}