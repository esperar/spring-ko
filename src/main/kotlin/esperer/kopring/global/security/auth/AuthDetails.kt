package esperer.kopring.global.security.auth

import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.member.type.UserStatus
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class AuthDetails(
    private val member: Member
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?> =
        member.roles

    override fun getPassword(): String? =
        null

    override fun getUsername(): String =
        member.email

    override fun isAccountNonExpired(): Boolean =
        true

    override fun isAccountNonLocked(): Boolean =
        member.state.equals(UserStatus.CREATED)


    override fun isCredentialsNonExpired(): Boolean =
        true

    override fun isEnabled(): Boolean =
        isAccountNonExpired && isAccountNonLocked && isCredentialsNonExpired}