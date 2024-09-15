package yoshibata.exam.quocard.libraryApp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import yoshibata.exam.quocard.libraryApp.service.AuthorInfo
import yoshibata.exam.quocard.libraryApp.service.BookInfo

@RequestMapping("api/v1/book")
interface AuthorController {
    @GetMapping("{authorId}")
    fun getAuthor(@PathVariable authorId: Int): ResponseEntity<AuthorInfo>

    @GetMapping("{authorId}/work")
    fun getAuthorWork(@PathVariable authorId: Int): ResponseEntity<List<BookInfo>>

    @PostMapping("")
    fun postAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<Int>

    @PutMapping("{authorId}")
    fun putAuthor(@PathVariable authorId: Int, @RequestBody authorDto: AuthorDto): ResponseEntity<HttpStatus>
}
