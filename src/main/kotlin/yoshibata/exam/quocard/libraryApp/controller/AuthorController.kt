package yoshibata.exam.quocard.libraryApp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import yoshibata.exam.quocard.libraryApp.repository.AuthorDto
import yoshibata.exam.quocard.libraryApp.service.AuthorInfo
import yoshibata.exam.quocard.libraryApp.service.SearchAuthorInfo

@RequestMapping("api/v1/author")
interface AuthorController {
    @GetMapping("{authorId}")
    fun getAuthor(@PathVariable authorId: Int): ResponseEntity<AuthorInfo>

    @PostMapping("")
    fun postAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<Int>

    @PutMapping("{authorId}")
    fun putAuthor(@PathVariable authorId: Int, @RequestBody authorDto: AuthorDto): ResponseEntity<HttpStatus>

    @GetMapping("")
    fun searchAuthor(@RequestParam("name") name: String): ResponseEntity<List<SearchAuthorInfo>>
}
