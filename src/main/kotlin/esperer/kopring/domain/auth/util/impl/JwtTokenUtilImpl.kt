package esperer.kopring.domain.auth.util.impl

import esperer.kopring.domain.auth.presentation.data.response.TokenResponse
import esperer.kopring.domain.auth.util.JwtTokenUtil
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.domain.member.exception.MemberNotFoundException
import esperer.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Component

@Component
class JwtTokenUtilImpl(
    private val jwtTokenProvider: JwtTokenProvider,
    private val memberRepository: MemberRepository
): JwtTokenUtil {

    override fun generateToken(email: String): TokenResponse {
        val member = memberRepository.findByEmail(email)
            ?: throw MemberNotFoundException();
        val accessToken = jwtTokenProvider.generateAccessToken(email)
        val refreshToken = jwtTokenProvider.generateRefreshToken(email)
        return TokenResponse(accessToken, refreshToken, jwtTokenProvider.accessExpiredTime)
    }
}