package esperer.kopring.domain.auth.presentation.data.dto

import org.springframework.web.multipart.MultipartFile

data class MemberDto(
    val userId: Long,
    val email: String,
    val password: String,
    val name: String,
    val file: MultipartFile?
)