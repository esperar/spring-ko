package esperer.kopring.domain.post.domain.repository

import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.post.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByIdAndMember(id: Long, member: Member): Post?
    fun deleteByIdAndMember(id: Long, member: Member)
}