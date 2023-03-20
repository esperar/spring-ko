package esperer.kopring.domain.member.service

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto

interface MemberProfileImageService {
    fun execute(memberDto: MemberDto)
}