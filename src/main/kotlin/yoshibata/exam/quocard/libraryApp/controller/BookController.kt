package yoshibata.exam.quocard.libraryApp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import yoshibata.exam.quocard.libraryApp.repository.BookDto
import yoshibata.exam.quocard.libraryApp.service.BookInfo
import yoshibata.exam.quocard.libraryApp.service.SearchBookInfo

@RequestMapping("api/v1/book")
interface BookController {
    @GetMapping("{bookId}")
    fun getBook(@PathVariable bookId: Int): ResponseEntity<BookInfo>

    @PostMapping("")
    fun postBook(@RequestBody bookDto: BookDto): ResponseEntity<Int>

    @PutMapping("{bookId}")
    fun putBook(@PathVariable bookId: Int, @RequestBody bookDto: BookDto): ResponseEntity<HttpStatus>

    @GetMapping("")
    fun searchBook(@RequestParam("title") title: String): ResponseEntity<List<SearchBookInfo>>
}

