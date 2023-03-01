package esperer.kopring.domain.post.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.exception.PostNotFoundException
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class DeletePostService(
    private val postRepository: PostRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(id: Long) =
        postRepository.deleteByIdAndMember(id, memberUtil.currentMember())
}