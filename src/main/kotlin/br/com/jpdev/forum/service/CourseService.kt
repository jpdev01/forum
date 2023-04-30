package br.com.jpdev.forum.service

import br.com.jpdev.forum.model.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(
        private var courseList: List<Course>
) {

    init {
        courseList = Arrays.asList(
                Course(
                        id = 1,
                        name = "Kotlin",
                        category = "Programação"
                )
        )
    }

    fun find(id: Long): Course {
        return courseList.stream().filter({
            it.id == id
        }).findFirst().get()
    }
}