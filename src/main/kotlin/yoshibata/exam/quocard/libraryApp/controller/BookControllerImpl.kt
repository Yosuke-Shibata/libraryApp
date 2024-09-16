package yoshibata.exam.quocard.libraryApp.controller

import org.jooq.exception.NoDataFoundException
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.resource.NoResourceFoundException
import yoshibata.exam.quocard.libraryApp.repository.BookDto
import yoshibata.exam.quocard.libraryApp.service.BookInfo
import yoshibata.exam.quocard.libraryApp.service.BookService
import yoshibata.exam.quocard.libraryApp.service.SearchBookInfo

@RestController
class BookControllerImpl(private val bookService: BookService) : BookController {
    override fun getBook(bookId: Int): ResponseEntity<BookInfo> {
        val result = try {
            this.bookService.get(bookId)
        } catch (error: NoDataFoundException) {
            throw NoResourceFoundException(HttpMethod.GET, "/api/v1/book")
        }
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

    override fun searchBook(title: String): ResponseEntity<List<SearchBookInfo>> {
        val results = this.bookService.search(title)
        return ResponseEntity(results, HttpStatus.OK)
    }

}