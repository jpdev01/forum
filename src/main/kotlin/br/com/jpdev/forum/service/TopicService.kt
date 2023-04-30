package br.com.jpdev.forum.service

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.dto.UpdateTopicRequestForm
import br.com.jpdev.forum.exception.NotFoundException
import br.com.jpdev.forum.mapper.TopicFormMapper
import br.com.jpdev.forum.mapper.TopicViewMapper
import br.com.jpdev.forum.model.Topic
import br.com.jpdev.forum.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
        private val topicRepository: TopicRepository,
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper,
        private val notFoundMessage: String = "Topico não encontrado"
) {

    fun list(courseName: String?) : List<TopicView> {
        var topicList = if (courseName == null) {
            topicRepository.findAll()
        } else {
            topicRepository.findByCourseName(courseName)
        }
        return topicList.stream().map { topicViewMapper.map(it) }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        var topic = topicRepository.findById(id)
                .orElseThrow { NotFoundException(notFoundMessage) }

        return topicViewMapper.map(topic)
    }

    fun save(topicDto: SaveTopicRequestForm): TopicView {
        val topic = topicFormMapper.map(topicDto)

        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicRequestForm): TopicView {
        var topic = topicRepository.findById(form.id)
                .orElseThrow { NotFoundException(notFoundMessage) }

        topic.title = form.title
        topic.message = form.message


        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        topicRepository.deleteById(id)
    }
}