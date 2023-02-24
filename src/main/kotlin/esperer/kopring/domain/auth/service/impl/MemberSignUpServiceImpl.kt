package esperer.kopring.domain.auth.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.service.MemberSignUpService
import esperer.kopring.domain.auth.util.AccountConverter
import esperer.kopring.domain.auth.util.AccountValidator
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.global.annotation.TransactionalService
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class MemberSignUpServiceImpl(
    private val accountConverter: AccountConverter,
    private val accountValidator: AccountValidator,
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
): MemberSignUpService {

    override fun signUp(memberDto: MemberDto) {
        accountValidator.validateSignUp(memberDto)
            .let { accountConverter.toEntity(memberDto, passwordEncoder.encode(memberDto.password)) }
            .let { memberRepository.save(it) }
    }

}