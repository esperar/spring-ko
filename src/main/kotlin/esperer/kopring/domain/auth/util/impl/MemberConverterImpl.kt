package esperer.kopring.domain.auth.util.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.request.LoginRequest
import esperer.kopring.domain.auth.presentation.data.request.SignUpRequest
import esperer.kopring.domain.auth.util.MemberConverter
import esperer.kopring.domain.member.domain.Member
import esperer.kopring.domain.member.type.Role
import esperer.kopring.domain.member.type.UserStatus
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Component
class MemberConverterImpl: MemberConverter {

    override fun toDto(request: SignUpRequest) =
        MemberDto(-1, request.email, request.password, request.name, null)

    override fun toDto(request: LoginRequest): MemberDto =
        MemberDto(-1, request.email, request.password, "", null)

    override fun toDto(file: MultipartFile): MemberDto =
        MemberDto(-1,"", "", "", file)

    override fun toEntity(dto: MemberDto, encodePassword: String): Member =
        Member(-1, dto.email, encodePassword, dto.name, "", "", Collections.singletonList(Role.ROLE_USER),UserStatus.CREATED)

}