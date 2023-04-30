package br.com.jpdev.forum.service

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.repository.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(
        private val courseRepository: CourseRepository
) {

    fun find(id: Long): Course {
        return courseRepository.findById(id).get()
    }
}