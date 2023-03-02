package esperer.kopring.domain.comment.service

import esperer.kopring.domain.comment.converter.CommentConverter
import esperer.kopring.domain.comment.domain.repository.CommentRepository
import esperer.kopring.domain.comment.exception.CommentNotFoundException
import esperer.kopring.domain.comment.presentation.dto.response.CommentResponse
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.exception.PostNotFoundException
import esperer.kopring.global.annotation.ReadOnlyService
import org.springframework.data.repository.findByIdOrNull

@ReadOnlyService
class GetCommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
    private val commentConverter: CommentConverter
    ) {

    fun execute(postId: Long): List<CommentResponse> =
        postRepository.findByIdOrNull(postId)
            .let { it ?: throw PostNotFoundException() }
            .let { commentRepository.findAllByPost(it) }
            .map { commentConverter.toCommentResponse(it) }

}