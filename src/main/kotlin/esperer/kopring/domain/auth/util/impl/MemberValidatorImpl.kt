package esperer.kopring.domain.auth.util.impl

import esperer.kopring.domain.auth.exception.DuplicateEmailException
import esperer.kopring.domain.auth.exception.PasswordNotCorrectException
import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType
import esperer.kopring.domain.auth.util.MemberValidator
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.domain.member.exception.MemberNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class MemberValidatorImpl(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
): MemberValidator {

    private fun validateSignUp(dto: MemberDto) {
        if (memberRepository.existsByEmail(dto.email)) {
            throw DuplicateEmailException()
        }
    }


    private fun validateLogin(email: String, password: String) {
        memberRepository.findByEmail(email).let {
            it ?: throw MemberNotFoundException()
        }.let {
            passwordEncoder.matches(password, it.password)
        }.let {
            if (it) return
            else throw PasswordNotCorrectException()
        }
    }

    override fun validate(validatorType: ValidatorType, dto: MemberDto) {
        when(validatorType){
            ValidatorType.LOGIN -> validateLogin(dto.email, dto.password)
            ValidatorType.SIGNUP -> validateSignUp(dto)
        }
    }


}