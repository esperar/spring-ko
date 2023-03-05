package esperer.kopring.domain.admin.service

import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class DeleteAllPostService(
    private val postRepository: PostRepository
) {
    fun execute() =
        postRepository.deleteAll()
}