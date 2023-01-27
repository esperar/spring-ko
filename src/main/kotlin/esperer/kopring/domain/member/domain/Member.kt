package esperer.kopring.domain.member.domain

import esperer.kopring.domain.member.type.Role
import esperer.kopring.domain.member.type.UserStatus
import javax.persistence.*

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", nullable = false)
    val id: Long,
    @Column(name = "email")
    val email: String,
    @Column(name = "password")
    val password: String,
    @Column(name = "name")
    var name: String,
    @Column(name = "refresh_token")
    var refreshToken: String?,
    @Column(name = "image_url")
    var imageUrl: String,
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "role", joinColumns = [JoinColumn(name = "id")])
    val roles: MutableList<Role> = mutableListOf(),

    @Enumerated(EnumType.STRING)
    val state: UserStatus,
) {

}