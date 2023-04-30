package br.com.jpdev.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class SaveTopicRequestForm(
        @field:NotEmpty @field:Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres") val title: String,
        @field:NotEmpty val message: String,
        @field:NotNull val courseId: Long,
        @field:NotNull val authorId: Long
)