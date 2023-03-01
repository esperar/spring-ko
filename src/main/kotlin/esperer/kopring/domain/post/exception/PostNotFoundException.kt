package esperer.kopring.domain.post.exception

import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException

class PostNotFoundException : BusinessException(ErrorCode.POST_NOT_FOUND)