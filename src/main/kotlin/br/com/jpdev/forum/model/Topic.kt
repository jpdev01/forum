package br.com.jpdev.forum.model

import br.com.jpdev.forum.model.enums.TopicStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topic(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var title: String,
        var message: String,
        val dateCreated: LocalDateTime = LocalDateTime.now(),

        @ManyToOne
        val course: Course,
        @ManyToOne
        var author: User,

        @Enumerated(value =  EnumType.STRING)
        val status: TopicStatus = TopicStatus.PENDING,

        @OneToMany(mappedBy = "topic")
        val answerList: List<Answer> = ArrayList()
)