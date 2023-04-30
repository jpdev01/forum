package br.com.jpdev.forum.controller

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.dto.UpdateTopicRequestForm
import br.com.jpdev.forum.service.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
        private val topicService: TopicService
) {

    @GetMapping
    fun list(): List<TopicView> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @PostMapping
    fun save(@RequestBody @Valid topic: SaveTopicRequestForm) {
        topicService.save(topic)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicRequestForm) {
        topicService.update(form)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}