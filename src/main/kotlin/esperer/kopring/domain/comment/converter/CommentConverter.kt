package esperer.kopring.domain.comment.converter

import esperer.kopring.domain.comment.domain.Comment
import esperer.kopring.domain.comment.presentation.dto.response.CommentResponse
import org.springframework.stereotype.Component

@Component
class CommentConverter {

    fun toCommentResponse(comment: Comment) =
        CommentResponse(comment.id, comment.content, comment.member.name)
}