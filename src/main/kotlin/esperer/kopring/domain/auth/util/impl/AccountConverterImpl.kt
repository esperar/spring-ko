package esperer.kopring.domain.auth.util.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.request.LoginRequest
import esperer.kopring.domain.auth.presentation.data.request.SignUpRequest
import esperer.kopring.domain.auth.util.AccountConverter
import org.springframework.stereotype.Component

@Component
class AccountConverterImpl: AccountConverter {

    override fun toDto(request: SignUpRequest) =
        MemberDto(-1, request.email, request.password, request.name, null)

    override fun toDto(request: LoginRequest): MemberDto =
        MemberDto(-1, request.email, request.password, "", null)

}