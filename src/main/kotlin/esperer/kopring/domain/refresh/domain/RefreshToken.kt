package esperer.kopring.domain.refresh.domain

import esperer.kopring.global.security.jwt.JwtTokenProvider
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import org.springframework.stereotype.Indexed

@RedisHash(value = "refreshToken", timeToLive = JwtTokenProvider.REFRESH_EXP)
class RefreshToken(
    @Id
    @Indexed
    val userId: Long,
    @Indexed
    val token: String,
)