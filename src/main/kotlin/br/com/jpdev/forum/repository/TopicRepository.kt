package br.com.jpdev.forum.repository

import br.com.jpdev.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String): List<Topic>
}