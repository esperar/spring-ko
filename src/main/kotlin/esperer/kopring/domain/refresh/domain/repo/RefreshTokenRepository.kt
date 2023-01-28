package esperer.kopring.domain.refresh.domain.repo

import esperer.kopring.domain.refresh.domain.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository: JpaRepository<RefreshToken, String> {
}