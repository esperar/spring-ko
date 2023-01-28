package esperer.kopring.domain.auth.util.impl

import esperer.kopring.domain.auth.exception.DuplicateEmailException
import esperer.kopring.domain.auth.exception.PasswordNotCorrectException
import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType
import esperer.kopring.domain.auth.util.AccountValidator
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.domain.member.exception.MemberNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AccountValidatorImpl(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
): AccountValidator {

    override fun validate(validatorType: ValidatorType, dto: MemberDto) {
        when (validatorType) {
            ValidatorType.SIGNUP -> validatorSignUpEmail(dto.email)
            ValidatorType.LOGIN -> validatorLoginInfo(dto.email, dto.password)
        }
    }

    private fun validatorSignUpEmail(email: String) {
        if (memberRepository.existsByEmail(email)) {
            throw DuplicateEmailException()
        }
    }

    private fun validatorLoginInfo(email: String, password: String) {
        memberRepository.findByEmail(email).let {
            it ?: throw MemberNotFoundException()
        }.let {
            passwordEncoder.matches(password, it.password)
        }.let {
            if (it) return
            else throw PasswordNotCorrectException()
        }
    }
}