package esperer.kopring.domain.auth.service

import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.global.annotation.TransactionalService
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class MemberSignUpService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun execute(){

    }

}