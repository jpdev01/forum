package br.com.jpdev.forum.service

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.model.Topic
import br.com.jpdev.forum.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicService(
        private var topicList: List<Topic>
) {

    init {
        topicList = Arrays.asList(
                Topic(
                        id = 1,
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
                ),
                Topic(
                        id = 1,
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
        )
    }
    fun save(): Topic {
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

        return topic
    }

    fun list() : List<Topic> {
        return topicList
    }

    fun findById(id: Long): Topic {
        return topicList.stream().filter({
            it.id == id
        }).findFirst().get()
    }
}