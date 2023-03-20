package esperer.kopring.domain.auth.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType
import esperer.kopring.domain.auth.service.MemberSignUpService
import esperer.kopring.domain.auth.util.MemberConverter
import esperer.kopring.domain.auth.util.MemberValidator
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.global.annotation.TransactionalService
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class MemberSignUpServiceImpl(
    private val memberConverter: MemberConverter,
    private val memberValidator: MemberValidator,
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
): MemberSignUpService {

    override fun execute(memberDto: MemberDto) {
        memberValidator.validate(ValidatorType.SIGNUP, memberDto)
            .let { memberConverter.toEntity(memberDto, passwordEncoder.encode(memberDto.password)) }
            .let { memberRepository.save(it) }
    }

}