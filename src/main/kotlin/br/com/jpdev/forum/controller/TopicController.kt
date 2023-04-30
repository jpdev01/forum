package br.com.jpdev.forum.controller

import br.com.jpdev.forum.dto.SaveTopicDTO
import br.com.jpdev.forum.model.Topic
import br.com.jpdev.forum.service.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(
        private val topicService: TopicService
) {

    @GetMapping
    fun list(): List<Topic> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): Topic {
        return topicService.findById(id)
    }

    @PostMapping
    fun save(@RequestBody topic: SaveTopicDTO) {
        topicService.save(topic)
    }
}