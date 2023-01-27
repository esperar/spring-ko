package esperer.kopring.global.security.exception

import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException

class InvalidTokenException: BusinessException(ErrorCode.INVALID_TOKEN)