package br.com.jpdev.forum.service

import br.com.jpdev.forum.dto.SaveTopicDTO
import br.com.jpdev.forum.model.Topic
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicService(
        private var topicList: List<Topic> = ArrayList(),
        private val courseService: CourseService,
        private val userService: UserService
) {

    fun list() : List<Topic> {
        return topicList
    }

    fun findById(id: Long): Topic {
        return topicList.stream().filter({
            it.id == id
        }).findFirst().get()
    }

    fun save(topicDto: SaveTopicDTO) {
        var topic = Topic(
                id = topicList.size.toLong() + 1,
                title = topicDto.title,
                message = topicDto.message,
                course = courseService.find(topicDto.courseId),
                author = userService.find(topicDto.authorId)
        )
        topicList = topicList.plus(topic)
    }
}