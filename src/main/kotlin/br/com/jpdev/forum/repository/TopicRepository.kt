package br.com.jpdev.forum.repository

import br.com.jpdev.forum.dto.TopicPerCategoryDTO
import br.com.jpdev.forum.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pageable: Pageable): Page<Topic>

    @Query("SELECT new br.com.jpdev.forum.dto.TopicPerCategoryDTO(course.category, count(t.id)) FROM Topic t JOIN t.course course GROUP BY course.category")
    fun report() : List<TopicPerCategoryDTO>
}