package br.com.jpdev.forum.controller

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.dto.UpdateTopicRequestForm
import br.com.jpdev.forum.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
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
    fun save(
            @RequestBody @Valid topic: SaveTopicRequestForm,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        var topicView = topicService.save(topic)

        var uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity
                .created(uri)
                .body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicRequestForm): ResponseEntity<TopicView> {
        var updatedTopicView = topicService.update(form)

        return ResponseEntity.ok(updatedTopicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}