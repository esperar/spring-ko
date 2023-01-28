package esperer.kopring.domain.auth.util

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.request.SignUpRequest

interface AccountConverter {
    fun toDto(request: SignUpRequest): MemberDto
}