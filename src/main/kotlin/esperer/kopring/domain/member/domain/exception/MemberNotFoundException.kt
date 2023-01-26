package esperer.kopring.domain.member.domain.exception

import esperer.kopring.global.error.ErrorCode
import esperer.kopring.global.error.exception.BusinessException

class MemberNotFoundException: BusinessException(ErrorCode.MEMBER_NOT_FOUND)