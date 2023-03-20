package esperer.kopring.domain.member.service.impl

import esperer.kopring.domain.auth.presentation.data.dto.MemberDto
import esperer.kopring.domain.member.service.MemberProfileImageService
import esperer.kopring.domain.auth.util.MemberUtil
import esperer.kopring.domain.member.domain.repo.MemberRepository
import esperer.kopring.global.annotation.TransactionalService
import esperer.kopring.infra.s3.service.S3Service

@TransactionalService
class MemberProfileImageServiceImpl(
    private val memberUtil: MemberUtil,
    private val s3Service: S3Service,
    private val memberRepository: MemberRepository
) : MemberProfileImageService {

    override fun execute(memberDto: MemberDto) {
        val uploadFile = memberDto.file?.let { s3Service.uploadFile(it, "USER/") }
        memberUtil.currentMember()
            .let {
                if(uploadFile != null) memberRepository.save(it.updateMemberProfileImage(uploadFile))
                else memberRepository.save(it.updateMemberProfileImage(it.imageUrl))
            }
    }
}