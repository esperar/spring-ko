package esperer.kopring.domain.auth.service

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto

interface MemberAuthService {
    fun signUp(memberDto: MemberDto)
}