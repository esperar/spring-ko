package esperer.kopring.global.security.exception

import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException

class ExpiredTokenException: BusinessException(ErrorCode.EXPIRATION_TOKEN)