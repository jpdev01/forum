package br.com.jpdev.forum.mapper

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.model.Topic
import br.com.jpdev.forum.service.CourseService
import br.com.jpdev.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
        private val courseService: CourseService,
        private val userService: UserService,
) : Mapper<SaveTopicRequestForm, Topic> {

    override fun map(form: SaveTopicRequestForm): Topic {
        return Topic(
                title = form.title,
                message = form.message,
                course = courseService.find(form.courseId),
                author = userService.find(form.authorId)
        )
    }
}