package esperer.kopring.domain.post.service

import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class UpdatePostService(
    private val postRepository: PostRepository,
    private val memberUtil: MemberUtil
) {

    fun execute(id: Long) =
        postRepository.findByIdAndMember(id, memberUtil.currentMember())
            .let {  }
}