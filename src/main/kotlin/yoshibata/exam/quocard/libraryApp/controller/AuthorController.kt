package yoshibata.exam.quocard.libraryApp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import yoshibata.exam.quocard.libraryApp.jooq.tables.records.AuthorRecord
import yoshibata.exam.quocard.libraryApp.repository.AuthorDto
import yoshibata.exam.quocard.libraryApp.service.AuthorInfo

@RequestMapping("api/v1/Author")
interface AuthorController {
    @GetMapping("{authorId}")
    fun getAuthor(@PathVariable authorId: Int): ResponseEntity<AuthorInfo>

    @PostMapping("")
    fun postAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<Int>

    @PutMapping("{authorId}")
    fun putAuthor(@PathVariable authorId: Int, @RequestBody authorDto: AuthorDto): ResponseEntity<HttpStatus>

    @GetMapping("")
    fun searchAuthor(@RequestParam("name") name: String): ResponseEntity<List<AuthorRecord>>
}
