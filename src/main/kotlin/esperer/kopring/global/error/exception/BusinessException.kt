package esperer.kopring.global.error.exception;

import esperer.kopring.global.error.ErrorCode

open class BusinessException(
        val errorCode: ErrorCode
        ) : RuntimeException(errorCode.message)