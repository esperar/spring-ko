package esperer.kopring.domain.auth.util

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.member.domain.Member

interface MemberUtil {
    fun currentMember(): Member
    fun findMemberById(memberDto: MemberDto): Member
}