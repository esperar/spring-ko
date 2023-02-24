package esperer.kopring.domain.auth.presentation

import esperer.kopring.domain.auth.presentation.data.request.LoginRequest
import esperer.kopring.domain.auth.presentation.data.request.SignUpRequest
import esperer.kopring.domain.auth.presentation.data.response.TokenResponse
import esperer.kopring.domain.auth.service.MemberLoginService
import esperer.kopring.domain.auth.service.MemberSignUpService
import esperer.kopring.domain.auth.util.AccountConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController(
    private val memberSignUpService: MemberSignUpService,
    private val memberLoginService: MemberLoginService,
    private val accountConverter: AccountConverter
) {

    @PostMapping
    fun signUp(@RequestBody @Valid request: SignUpRequest) : ResponseEntity<Void> =
        accountConverter.toDto(request)
            .let { memberSignUpService.execute(it) }
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PostMapping("login")
    fun login(@RequestBody @Valid request: LoginRequest): ResponseEntity<TokenResponse> =
        accountConverter.toDto(request)
            .let { memberLoginService.execute(it) }
            .let { ResponseEntity.ok(it) }

}