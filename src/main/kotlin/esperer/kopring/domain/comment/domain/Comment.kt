package esperer.kopring.domain.comment.domain

import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.post.domain.Post
import esperer.kopring.global.entity.BaseIdEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Comment(
    val content: String,

    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: Member,

    @ManyToOne
    @JoinColumn(name = "post_id")
    val post: Post
) : BaseIdEntity(){
}