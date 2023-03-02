package esperer.kopring.domain.comment.service

import esperer.kopring.domain.comment.domain.repository.CommentRepository
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.global.annotation.ReadOnlyService

@ReadOnlyService
class GetCommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,

    ) {
}