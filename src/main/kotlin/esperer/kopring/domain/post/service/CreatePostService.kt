package esperer.kopring.domain.post.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.presentation.dto.request.CreatePostRequest
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class CreatePostService(
    private val postRepository: PostRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(createPostRequest: CreatePostRequest): Long =
        memberUtil.currentMember()
            .let { postRepository.save(createPostRequest.toEntity(it)).id }
}