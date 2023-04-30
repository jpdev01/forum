package br.com.jpdev.forum.controller

import br.com.jpdev.forum.model.Course
import br.com.jpdev.forum.model.Topic
import br.com.jpdev.forum.model.User
import br.com.jpdev.forum.service.TopicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Arrays

@RestController
@RequestMapping("/topics")
class TopicController(
        private val topicService: TopicService
) {

    @GetMapping
    fun list(): List<Topic> {
        val topic = topicService.save() // MOCK!

        return topicService.list()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): Topic {
        return topicService.findById(id)
    }
}