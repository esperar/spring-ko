package esperer.kopring.domain.auth.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.response.TokenResponse
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType
import esperer.kopring.domain.auth.service.MemberLoginService
import esperer.kopring.domain.auth.util.AccountConverter
import esperer.kopring.domain.auth.util.AccountValidator
import esperer.kopring.domain.auth.util.JwtTokenUtil
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.global.annotation.TransactionalService
import esperer.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class MemberLoginServiceImpl (
    private val accountValidator: AccountValidator,
    private val jwtTokenUtil: JwtTokenUtil
): MemberLoginService {

    override fun execute(memberDto: MemberDto): TokenResponse =
        accountValidator.validate(ValidatorType.LOGIN, memberDto)
            .let{ jwtTokenUtil.generateToken(memberDto.email )}

}