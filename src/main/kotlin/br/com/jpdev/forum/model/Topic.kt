package br.com.jpdev.forum.model

import br.com.jpdev.forum.model.enums.TopicStatus
import java.time.LocalDateTime

data class Topic(
        val id: Long? = null,
        val title: String,
        val message: String,
        val dateCreated: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        var author: User,
        val status: TopicStatus = TopicStatus.PENDING,
        val answerList: List<Answer> = ArrayList()
)