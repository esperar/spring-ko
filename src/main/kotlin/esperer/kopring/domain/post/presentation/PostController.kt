package esperer.kopring.domain.post.presentation

import esperer.kopring.domain.post.presentation.dto.request.CreatePostRequest
import esperer.kopring.domain.post.service.CreatePostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/post")
class PostController(
    private val createPostService: CreatePostService
) {

    @PostMapping
    fun createPost(@RequestBody @Valid createPostRequest: CreatePostRequest): ResponseEntity<Long> =
        createPostService.execute(createPostRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }
}