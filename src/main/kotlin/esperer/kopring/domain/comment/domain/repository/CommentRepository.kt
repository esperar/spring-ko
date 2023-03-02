package esperer.kopring.domain.comment.domain.repository

import esperer.kopring.domain.comment.domain.Comment
import esperer.kopring.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findAllByPost(post: Post): List<Comment>
}