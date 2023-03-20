package esperer.kopring.domain.auth.util

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.request.LoginRequest
import esperer.kopring.domain.auth.presentation.data.request.SignUpRequest
import esperer.kopring.domain.member.domain.Member
import org.springframework.web.multipart.MultipartFile

interface MemberConverter {
    fun toDto(request: SignUpRequest): MemberDto
    fun toDto(request: LoginRequest): MemberDto
    fun toDto(file: MultipartFile): MemberDto
    fun toEntity(dto: MemberDto, encodePassword: String): Member
}