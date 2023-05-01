package br.com.jpdev.forum.service

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.model.User
import br.com.jpdev.forum.model.UserDetail
import br.com.jpdev.forum.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*
import kotlin.collections.ArrayList

@Service
class UserService(
        private val userRepository: UserRepository
) : UserDetailsService {

    fun find(id: Long): User {
        return userRepository.findById(id).get()
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByEmail(username) ?: throw RuntimeException("Usuário incorreto ou inexistente")

        return UserDetail(user)
    }
}