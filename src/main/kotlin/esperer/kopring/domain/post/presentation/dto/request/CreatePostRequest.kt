package esperer.kopring.domain.post.presentation.dto.request

import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.post.domain.Post
import javax.validation.constraints.Size

data class CreatePostRequest(
    @field:Size(min = 1, max = 50)
    val title: String,

    @field:Size(min = 1, max = 254)
    val content: String
) {

    fun toEntity(member: Member): Post = Post(title, content, member)
}