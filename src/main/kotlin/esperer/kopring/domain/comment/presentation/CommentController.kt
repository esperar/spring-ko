package esperer.kopring.domain.comment.presentation

import esperer.kopring.domain.comment.presentation.dto.request.CreateCommentRequest
import esperer.kopring.domain.comment.presentation.dto.response.CommentResponse
import esperer.kopring.domain.comment.service.CreateCommentService
import esperer.kopring.domain.comment.service.DeleteCommentService
import esperer.kopring.domain.comment.service.GetCommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comment")
class CommentController(
    private val createCommentService: CreateCommentService,
    private val getCommentService: GetCommentService,
    private val deleteCommentService: DeleteCommentService
) {

    @PostMapping("/{post_id}/comment")
    fun createComment(@PathVariable("post_id") postId: Long, createCommentRequest: CreateCommentRequest) : ResponseEntity<Long> =
       createCommentService.execute(postId, createCommentRequest)
           .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }

    @GetMapping("/{post_id}/comment")
    fun getComment(@PathVariable("post_id") postId: Long): ResponseEntity<List<CommentResponse>> =
        getCommentService.execute(postId)
            .let { ResponseEntity.ok(it) }

    @DeleteMapping("/{comment_id}")
    fun deleteComment(@PathVariable("comment_id") commentId: Long): ResponseEntity<Void> =
        deleteCommentService.execute(commentId)
            .let { ResponseEntity.ok().build() }


}