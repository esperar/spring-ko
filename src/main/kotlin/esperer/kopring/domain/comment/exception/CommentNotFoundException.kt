package esperer.kopring.domain.comment.exception

import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException

class CommentNotFoundException : BusinessException(ErrorCode.COMMENT_NOT_FOUND)