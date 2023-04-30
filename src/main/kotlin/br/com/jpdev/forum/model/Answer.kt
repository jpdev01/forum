package br.com.jpdev.forum.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Answer(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val message: String,
        val dateCreated: LocalDateTime =  LocalDateTime.now(),
        @ManyToOne
        val author: User,
        @ManyToOne
        val topic: Topic,
        val solveTopic: Boolean
)