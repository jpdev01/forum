package br.com.jpdev.forum.dto

data class SaveTopicDTO(
        val title: String,
        val message: String,
        val courseId: Long,
        val authorId: Long
)