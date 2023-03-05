package esperer.kopring.domain.admin.service

import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.exception.PostNotFoundException
import esperer.kopring.global.annotation.TransactionalService
import org.springframework.data.repository.findByIdOrNull

@TransactionalService
class DeletePostService(
    private val postRepository: PostRepository
) {

    fun execute(postId: Long) =
        postRepository.findByIdOrNull(postId)
            .let { it ?: throw PostNotFoundException() }
            .let { postRepository.delete(it) }
}