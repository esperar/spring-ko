package esperer.kopring.domain.auth.util

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType

interface AccountValidator {

    fun validate(validatorType: ValidatorType, dto: MemberDto)
}