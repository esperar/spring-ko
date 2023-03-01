package esperer.kopring.domain.post.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.exception.PostNotFoundException
import esperer.kopring.domain.post.presentation.dto.request.UpdatePostRequest
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class UpdatePostService(
    private val postRepository: PostRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(id: Long, updatePostRequest: UpdatePostRequest) =
        postRepository.findByIdAndMember(id, memberUtil.currentMember())
        .let { it ?: throw PostNotFoundException() }
            .updatePost(updatePostRequest)
}