package yoshibata.exam.quocard.libraryApp.controller

import org.jooq.generated.tables.records.BookRecord
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import yoshibata.exam.quocard.libraryApp.repository.BookDto
import yoshibata.exam.quocard.libraryApp.service.BookInfo
import yoshibata.exam.quocard.libraryApp.service.BookService

@RestController
class BookControllerImpl(private val bookService: BookService) : BookController {
    override fun getBook(bookId: Int): ResponseEntity<BookInfo> {
        val result = this.bookService.get(bookId)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun postBook(bookDto: BookDto): ResponseEntity<Int> {
        val result = this.bookService.post(bookDto)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun putBook(bookId: Int, bookDto: BookDto): ResponseEntity<HttpStatus> {
        this.bookService.put(bookId, bookDto)
        return ResponseEntity(HttpStatus.OK)
    }

    override fun searchBook(title: String): ResponseEntity<List<BookRecord>> {
        val results = this.bookService.search(title)
        return ResponseEntity(results, HttpStatus.OK)
    }

}