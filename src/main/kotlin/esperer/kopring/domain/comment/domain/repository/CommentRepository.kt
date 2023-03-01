package esperer.kopring.domain.comment.domain.repository

import esperer.kopring.domain.comment.domain.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}