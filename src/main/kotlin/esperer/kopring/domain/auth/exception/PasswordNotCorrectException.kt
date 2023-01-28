package esperer.kopring.domain.auth.exception

import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException

class PasswordNotCorrectException: BusinessException(ErrorCode.PASSWORD_NOT_CORRECT)