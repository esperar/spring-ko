package esperer.kopring.domain.post.converter

import esperer.kopring.domain.post.domain.Post
import esperer.kopring.domain.post.presentation.dto.response.PostResponse
import org.springframework.stereotype.Component

@Component
class PostConverter {

    fun toPostResponse(post: Post) =
        PostResponse(post.id, post.title, post.member.name)
}