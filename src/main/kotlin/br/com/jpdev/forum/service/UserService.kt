package br.com.jpdev.forum.service

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.model.User
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class UserService(
        private var userList: List<User>
) {

    init {
        userList = Arrays.asList(
                User(
                        id = 1,
                        name = "Ana",
                        email = "ana@gmail.com"
                )
        )
    }

    fun find(id: Long): User {
        return userList.stream().filter({
            it.id == id
        }).findFirst().get()
    }
}