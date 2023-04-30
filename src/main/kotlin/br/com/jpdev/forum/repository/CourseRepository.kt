package br.com.jpdev.forum.repository

import br.com.jpdev.forum.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
}