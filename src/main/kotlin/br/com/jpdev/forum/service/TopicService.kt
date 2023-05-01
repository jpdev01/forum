package br.com.jpdev.forum.service

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicPerCategoryDTO
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.dto.UpdateTopicRequestForm
import br.com.jpdev.forum.exception.NotFoundException
import br.com.jpdev.forum.mapper.TopicFormMapper
import br.com.jpdev.forum.mapper.TopicViewMapper
import br.com.jpdev.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class TopicService(
        private val topicRepository: TopicRepository,
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper,
        private val notFoundMessage: String = "Topico não encontrado",
        private val entityManager: EntityManager // só pra mostrar q pode
) {

    fun list(courseName: String?, pageable: Pageable) : Page<TopicView> {
        var topicList = if (courseName == null) {
            topicRepository.findAll(pageable)
        } else {
            topicRepository.findByCourseName(courseName, pageable)
        }
        return topicList.map { topicViewMapper.map(it) }
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

    fun report(): List<TopicPerCategoryDTO> {
        return topicRepository.report()
    }
}