package esperer.kopring.domain.post.domain

import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.post.presentation.dto.request.UpdatePostRequest
import esperer.kopring.global.entity.BaseIdEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Post(
    val title: String,
    val content: String,

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member
) : BaseIdEntity(){

    fun updatePost(updatePostRequest: UpdatePostRequest): Post{
        val post = Post(
            title = updatePostRequest.title,
            content = updatePostRequest.content,
            member = this.member
        )
        post.id = this.id
        return post
    }
}