package esperer.kopring.domain.post.domain.repository

import esperer.kopring.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {

}