package esperer.kopring.domain.post.domain

import esperer.kopring.domain.member.domain.Member
import esperer.kopring.global.entity.BaseIdEntity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class Post(
    val title: String,
    val content: String,

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member
) : BaseIdEntity(){
}