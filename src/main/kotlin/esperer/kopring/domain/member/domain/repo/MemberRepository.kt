package esperer.kopring.domain.member.domain.repo

import esperer.kopring.domain.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByEmail(email: String?): Member?
    fun existsByEmail(email: String): Boolean
}