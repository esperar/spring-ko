package esperer.kopring.domain.auth.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.response.TokenResponse
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType
import esperer.kopring.domain.auth.service.MemberLoginService
import esperer.kopring.domain.auth.util.MemberValidator
import esperer.kopring.domain.auth.util.JwtTokenUtil
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class MemberLoginServiceImpl (
    private val memberValidator: MemberValidator,
    private val jwtTokenUtil: JwtTokenUtil
): MemberLoginService {

    override fun execute(memberDto: MemberDto): TokenResponse =
        memberValidator.validate(ValidatorType.LOGIN, memberDto)
            .let{ jwtTokenUtil.generateToken(memberDto.email)}

}