package esperer.kopring.domain.comment.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.comment.domain.repository.CommentRepository
import esperer.kopring.domain.comment.exception.CommentNotFoundException
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class DeleteCommentService(
    private val commentRepository: CommentRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(id: Long) =
        commentRepository.findByIdAndMember(id, memberUtil.currentMember())
            .let { it ?: throw CommentNotFoundException() }
            .let { commentRepository.delete(it) }
}