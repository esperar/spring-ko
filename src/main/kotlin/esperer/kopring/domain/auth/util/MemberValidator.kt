package esperer.kopring.domain.auth.util

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.presentation.data.type.ValidatorType

interface MemberValidator {

    fun validate(validatorType: ValidatorType, dto: MemberDto)
}