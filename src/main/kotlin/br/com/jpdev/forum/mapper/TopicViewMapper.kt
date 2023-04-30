package br.com.jpdev.forum.mapper

import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {

    override fun map(topic: Topic): TopicView {
        return TopicView(
                id = topic.id,
                title = topic.title,
                message = topic.message,
                dateCreated = topic.dateCreated,
                status = topic.status
        )
    }
}