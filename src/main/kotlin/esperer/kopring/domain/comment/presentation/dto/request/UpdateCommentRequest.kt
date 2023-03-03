package esperer.kopring.domain.comment.presentation.dto.request

import javax.validation.constraints.Size

data class UpdateCommentRequest(
    @field:Size(min = 1, max = 20)
    val content: String
) {
}