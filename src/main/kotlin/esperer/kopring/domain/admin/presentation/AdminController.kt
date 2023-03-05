package esperer.kopring.domain.admin.presentation

import esperer.kopring.domain.admin.service.DeleteAllPostService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController(
    private val deleteAllPostService: DeleteAllPostService
) {

    @DeleteMapping("/delete-post")
    fun deleteAllPost(): ResponseEntity<Void> =
        deleteAllPostService.execute()
            .let { ResponseEntity.ok().build() }
}