package esperer.kopring.domain.auth.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.response.TokenResponse
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType
import esperer.kopring.domain.auth.service.MemberLoginService
import esperer.kopring.domain.auth.util.AccountConverter
import esperer.kopring.domain.auth.util.AccountValidator
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.global.annotation.TransactionalService
import esperer.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder

@TransactionalService
class MemberLoginServiceImpl (
    private val accountConverter: AccountConverter,
    private val accountValidator: AccountValidator,
    private val memberRepository: MemberRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder,
): MemberLoginService {

    override fun execute(memberDto: MemberDto): TokenResponse {
        accountValidator.validate(ValidatorType.LOGIN, memberDto)
            .let { jwtTokenProvider.generateAccessToken(memberDto.email) }
            .let { jwtTokenProvider.generateRefreshToken(memberDto.email) }
    }

}