package esperer.kopring.domain.post.service

import esperer.kopring.domain.post.converter.PostConverter
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.exception.PostNotFoundException
import esperer.kopring.domain.post.presentation.dto.response.PostDetailResponse
import esperer.kopring.domain.post.presentation.dto.response.PostResponse
import esperer.kopring.global.annotation.ReadOnlyService
import org.springframework.data.repository.findByIdOrNull


@ReadOnlyService
class GetPostService(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter
) {

    fun execute(id: Long): PostDetailResponse =
        postRepository.findByIdOrNull(id)
            .let { it ?: throw PostNotFoundException() }
            .let { postConverter.toPostDetailResponse(it) }
}