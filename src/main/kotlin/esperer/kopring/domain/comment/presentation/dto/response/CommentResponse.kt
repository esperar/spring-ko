package esperer.kopring.domain.comment.presentation.dto.response


data class CommentResponse(
    val commentId: Long,
    val content: String,
    val memberName: String
) {
}