package br.com.jpdev.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class SaveTopicRequestForm(
        @NotEmpty @Size(min = 5, max = 100) val title: String,
        @NotEmpty @Size(min = 5, max = 150) val message: String,
        @NotNull val courseId: Long,
        @NotNull val authorId: Long
)