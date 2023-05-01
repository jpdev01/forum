package br.com.jpdev.forum.controller

import br.com.jpdev.forum.dto.SaveTopicRequestForm
import br.com.jpdev.forum.dto.TopicPerCategoryDTO
import br.com.jpdev.forum.dto.TopicView
import br.com.jpdev.forum.dto.UpdateTopicRequestForm
import br.com.jpdev.forum.service.TopicService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
        private val topicService: TopicService
) {

    @GetMapping
    @Cacheable("topics")
    fun list(
            @RequestParam(required = false) courseName: String?,
            @PageableDefault(size = 10, sort = ["title"], direction = Sort.Direction.ASC) pageable: Pageable
    ): Page<TopicView> {
        return topicService.list(courseName, pageable)
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
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
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun update(@RequestBody @Valid form: UpdateTopicRequestForm): ResponseEntity<TopicView> {
        var updatedTopicView = topicService.update(form)

        return ResponseEntity.ok(updatedTopicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }

    @GetMapping("/export")
    fun report(): List<TopicPerCategoryDTO> {
        return topicService.report()
    }
}