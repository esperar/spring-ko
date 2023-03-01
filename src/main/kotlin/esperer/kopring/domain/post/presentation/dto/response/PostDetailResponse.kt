package esperer.kopring.domain.post.presentation.dto.response

data class PostDetailResponse(
    val id: Long,
    val title: String,
    val content: String,
    val memberName: String,
) {
}