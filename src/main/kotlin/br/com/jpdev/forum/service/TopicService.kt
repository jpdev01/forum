package br.com.jpdev.forum.service

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.dto.UpdateTopicRequestForm
import br.com.jpdev.forum.mapper.TopicFormMapper
import br.com.jpdev.forum.mapper.TopicViewMapper
import br.com.jpdev.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicService(
        private var topicList: List<Topic> = ArrayList(),
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper
) {

    fun list() : List<TopicView> {
        return topicList.stream().map { topicViewMapper.map(it) }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        var topic = topicList.stream().filter({
            it.id == id
        }).findFirst().get()

        return topicViewMapper.map(topic)
    }

    fun save(topicDto: SaveTopicRequestForm): TopicView {
        val topic = topicFormMapper.map(topicDto)
        topic.id = topicList.size.toLong() + 1

        topicList = topicList.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicRequestForm): TopicView {
        val topic = topicList.stream().filter { it.id == form.id }.findFirst().get()

        var updatedTopic = Topic(
                id = form.id,
                title = form.title,
                message = form.message,
                author = topic.author,
                course= topic.course,
                answerList = topic.answerList,
                status = topic.status,
                dateCreated = topic.dateCreated
        )
        topicList =  topicList.minus(topic).plus(updatedTopic)

        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topicList.stream().filter { it.id == id }.findFirst().get()
        topicList = topicList.minus(topic)
    }
}