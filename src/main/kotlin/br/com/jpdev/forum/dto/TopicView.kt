package br.com.jpdev.forum.dto

import br.com.jpdev.forum.model.enums.TopicStatus
import java.time.LocalDateTime

data class TopicView(
        val id: Long?,
        val title: String,
        val message: String,
        val status: TopicStatus,
        val dateCreated: LocalDateTime
)