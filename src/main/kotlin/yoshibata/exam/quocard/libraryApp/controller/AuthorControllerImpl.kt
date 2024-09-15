package yoshibata.exam.quocard.libraryApp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import yoshibata.exam.quocard.libraryApp.service.AuthorInfo
import yoshibata.exam.quocard.libraryApp.service.AuthorService
import yoshibata.exam.quocard.libraryApp.service.BookInfo
import yoshibata.exam.quocard.libraryApp.service.WorkService

@RestController
class AuthorControllerImpl(private val authorService: AuthorService, private val workService: WorkService) :
    AuthorController {
    override fun getAuthor(authorId: Int): ResponseEntity<AuthorInfo> {
        val result = this.authorService.get(authorId)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun getAuthorWork(authorId: Int): ResponseEntity<List<BookInfo>> {
        val result = this.workService.getBooks(authorId)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun postAuthor(authorDto: AuthorDto): ResponseEntity<Int> {
        val result = this.authorService.post(authorDto)
        return ResponseEntity(result, HttpStatus.OK)
    }

    override fun putAuthor(authorId: Int, authorDto: AuthorDto): ResponseEntity<HttpStatus> {
        this.authorService.put(authorId, authorDto)
        return ResponseEntity(HttpStatus.OK)
    }
}

data class AuthorDto(val name: String)