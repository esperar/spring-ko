package esperer.kopring.global.security.auth

import esperer.kopring.domain.member.domain.exception.MemberNotFoundException
import esperer.kopring.domain.member.domain.repo.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class AuthDetailsService(
    private val memberRepository: MemberRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails =
        AuthDetails(
            memberRepository.findByEmail(username)?: throw MemberNotFoundException()
        )
}