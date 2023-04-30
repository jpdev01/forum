package br.com.jpdev.forum.dto

data class SaveTopicRequestForm(
        val title: String,
        val message: String,
        val courseId: Long,
        val authorId: Long
)