package esperer.kopring.domain.auth.util.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.domain.member.exception.MemberNotFoundException
import esperer.kopring.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberUtilImpl(
    private val memberRepository: MemberRepository
): MemberUtil{

    @Transactional(readOnly = true, rollbackFor = [Exception::class])
    override fun currentMember(): Member {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val email = if (principal is UserDetails) {
            (principal as AuthDetails).username
        } else {
            principal.toString()
        }
        return findMemberByEmail(email)
    }

    override fun findMemberByEmail(email: String): Member =
        memberRepository.findByEmail(email) ?: throw MemberNotFoundException()

}