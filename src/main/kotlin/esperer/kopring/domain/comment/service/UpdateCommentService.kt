package esperer.kopring.domain.comment.service

import esperer.kopring.domain.comment.domain.repository.CommentRepository
import esperer.kopring.domain.comment.exception.CommentNotFoundException
import esperer.kopring.domain.comment.presentation.dto.request.UpdateCommentRequest
import esperer.kopring.global.annotation.TransactionalService
import org.springframework.data.repository.findByIdOrNull

@TransactionalService
class UpdateCommentService(
    private val commentRepository: CommentRepository
) {

    fun execute(commentId: Long, updateCommentRequest: UpdateCommentRequest) =
        commentRepository.findByIdOrNull(commentId)
            .let { it ?: CommentNotFoundException() }
            .let {  }

}