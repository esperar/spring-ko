package esperer.kopring.domain.post.presentation

import esperer.kopring.domain.admin.service.AdminDeletePostService
import esperer.kopring.domain.post.presentation.dto.request.CreatePostRequest
import esperer.kopring.domain.post.presentation.dto.request.UpdatePostRequest
import esperer.kopring.domain.post.presentation.dto.response.PostDetailResponse
import esperer.kopring.domain.post.presentation.dto.response.PostResponse
import esperer.kopring.domain.post.service.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/post")
class PostController(
    private val createPostService: CreatePostService,
    private val getPostService: GetPostService,
    private val getAllPostService: GetAllPostService,
    private val updatePostService: UpdatePostService,
    private val deletePostService: DeletePostService,
    private val adminDeletePostService: AdminDeletePostService
) {

    @PostMapping
    fun createPost(@RequestBody @Valid createPostRequest: CreatePostRequest): ResponseEntity<Long> =
        createPostService.execute(createPostRequest)
            .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): ResponseEntity<PostDetailResponse> =
        getPostService.execute(id)
            .let { ResponseEntity.ok(it) }

    @GetMapping
    fun getAllPost(): ResponseEntity<List<PostResponse>> =
        getAllPostService.execute()
            .let { ResponseEntity.ok(it) }

    @PatchMapping("/{id}")
    fun updatePost(@PathVariable id: Long, updatePostRequest: UpdatePostRequest): ResponseEntity<Void> =
        updatePostService.execute(id, updatePostRequest)
            .let { ResponseEntity.noContent().build() }


    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Void> =
        deletePostService.execute(id)
            .let { ResponseEntity.ok().build() }

    @DeleteMapping("/{id}/delete-post")
    fun adminDeletePost(@PathVariable id: Long): ResponseEntity<Void> =
        adminDeletePostService.execute(id)
            .let { ResponseEntity.ok().build() }

}