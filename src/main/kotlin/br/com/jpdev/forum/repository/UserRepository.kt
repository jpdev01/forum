package br.com.jpdev.forum.repository

import br.com.jpdev.forum.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {

    fun findByEmail(username: String?): User?
}