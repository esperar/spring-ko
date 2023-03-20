package esperer.kopring.domain.auth.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.auth.service.MemberProfileImageService
import esperer.kopring.domain.auth.util.MemberConverter
import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.global.annotation.TransactionalService

@TransactionalService
class MemberProfileImageServiceImpl(
    private val memberUtil: MemberUtil,
    private val memberConverter: MemberConverter

) : MemberProfileImageService {
    override fun execute(userDto: MemberDto) {
        TODO("Not yet implemented")
    }
}