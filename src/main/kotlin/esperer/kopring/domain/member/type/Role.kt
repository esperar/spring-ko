package esperer.kopring.domain.member.type

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ROLE_ADMIN, ROLE_USER;

    override fun getAuthority(): String {
        return name
    }
}