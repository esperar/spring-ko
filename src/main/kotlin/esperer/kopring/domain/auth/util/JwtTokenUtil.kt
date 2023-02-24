package esperer.kopring.domain.auth.util

import esperer.kopring.domain.auth.presentation.data.response.TokenResponse

interface JwtTokenUtil {
    fun generateToken(email: String): TokenResponse
}