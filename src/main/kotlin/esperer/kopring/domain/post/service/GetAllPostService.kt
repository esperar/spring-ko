package esperer.kopring.domain.post.service

import esperer.kopring.domain.post.converter.PostConverter
import esperer.kopring.domain.post.domain.repository.PostRepository
import esperer.kopring.domain.post.presentation.dto.response.PostResponse
import esperer.kopring.global.annotation.ReadOnlyService

@ReadOnlyService
class GetAllPostService (
    private val postRepository: PostRepository,
    private val postConverter: PostConverter
){

    fun execute(): List<PostResponse> =
        postRepository.findAll()
            .map { postConverter.toPostResponse(it) }
}