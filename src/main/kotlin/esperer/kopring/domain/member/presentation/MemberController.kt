package esperer.kopring.domain.member.presentation

import esperer.kopring.domain.auth.util.MemberConverter
import esperer.kopring.domain.member.service.MemberProfileImageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberProfileImageService: MemberProfileImageService,
    private val memberConverter: MemberConverter
) {

    @PatchMapping
    fun updateProfileImage(@RequestPart file: MultipartFile): ResponseEntity<Void> =
        memberConverter.toDto(file)
            .let { memberProfileImageService.execute(it) }
            .let { ResponseEntity.noContent().build() }
}