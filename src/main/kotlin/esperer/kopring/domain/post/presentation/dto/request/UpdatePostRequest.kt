package esperer.kopring.domain.post.presentation.dto.request

import javax.validation.constraints.Size

data class UpdatePostRequest(
    @field:Size(min = 1, max = 40)
    val title: String,

    @field:Size(min = 1, max = 254)
    val content:String
) {
}