package esperer.kopring.domain.comment.presentation.dto.request

import esperer.kopring.domain.comment.domain.Comment
import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.post.domain.Post
import javax.validation.constraints.Size

data class CreateCommentRequest(
    @field:Size(min = 1, max = 254)
    val content: String
) {
    fun toEntity(member: Member, post: Post): Comment =
        Comment(this.content, member, post)
}
