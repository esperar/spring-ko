package esperer.kopring.domain.auth.service

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.response.TokenResponse

interface MemberLoginService {
    fun execute(memberDto: MemberDto): TokenResponse
}