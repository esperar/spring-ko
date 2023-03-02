package esperer.kopring.domain.comment.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.comment.domain.repository.CommentRepository
import esperer.kopring.domain.comment.exception.CommentNotFoundException
import esperer.kopring.domain.comment.presentation.dto.request.CreateCommentRequest
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.global.annotation.TransactionalService
import org.springframework.data.repository.findByIdOrNull

@TransactionalService
class CreateCommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(postId: Long, createCommentRequest: CreateCommentRequest): Long =
        postRepository.findByIdOrNull(postId)
            .let { it ?: throw CommentNotFoundException() }
            .let { commentRepository.save(createCommentRequest
                .toEntity(memberUtil.currentMember(), it)) }.id

}