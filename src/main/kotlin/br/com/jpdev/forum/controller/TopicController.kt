package br.com.jpdev.forum.controller

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.model.Topic
import br.com.jpdev.forum.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Arrays

@RestController
@RequestMapping("/topics")
class TopicController {

    @GetMapping
    fun list(): List<Topic> {
        val topic = Topic(
                id=1,
                title = "Dúvida Kotlin",
                message = "Variaveis",
                course = Course(
                        id = 1,
                        name = "Kotlin",
                        category = "Programação"
                ),
                author = User(
                        id = 1,
                        name = "Ana",
                        email = "ana@gmail.com"
                )
        )

        return Arrays.asList(topic)
    }
}