package br.com.jpdev.forum.service

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
        private var topicList: List<Topic> = ArrayList(),
        private val courseService: CourseService,
        private val userService: UserService
) {

    fun list() : List<TopicView> {
        return topicList.stream().map { topic ->
            TopicView(
                    id = topic.id,
                    title = topic.title,
                    message = topic.message,
                    dateCreated = topic.dateCreated,
                    status = topic.status
            )
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        var topic = topicList.stream().filter({
            it.id == id
        }).findFirst().get()

        return TopicView(
                id = topic.id,
                title = topic.title,
                message = topic.message,
                dateCreated = topic.dateCreated,
                status = topic.status
        )
    }

    fun save(topicDto: SaveTopicRequestForm) {
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