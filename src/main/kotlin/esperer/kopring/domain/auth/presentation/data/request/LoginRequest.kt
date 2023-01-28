package esperer.kopring.domain.auth.presentation.data.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank
    @field:Email
    val email: String,
    @field:NotBlank
    val password: String
)
