package esperer.kopring.domain.comment.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.comment.domain.repository.CommentRepository
import esperer.kopring.domain.comment.exception.CommentNotFoundException
import esperer.kopring.domain.comment.presentation.dto.request.UpdateCommentRequest
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class UpdateCommentService(
    private val commentRepository: CommentRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(commentId: Long, updateCommentRequest: UpdateCommentRequest) =
        commentRepository.findByIdAndMember(commentId, memberUtil.currentMember())
            .let { it ?: throw CommentNotFoundException() }
            .let { commentRepository.save(it.update(updateCommentRequest)) }

}