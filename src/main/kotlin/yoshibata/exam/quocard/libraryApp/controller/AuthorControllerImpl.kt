package yoshibata.exam.quocard.libraryApp.controller

import org.jooq.generated.tables.records.AuthorRecord
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import yoshibata.exam.quocard.libraryApp.repository.AuthorDto
import yoshibata.exam.quocard.libraryApp.service.AuthorInfo
import yoshibata.exam.quocard.libraryApp.service.AuthorService

@RestController
class AuthorControllerImpl(private val authorService: AuthorService) :
    AuthorController {
    override fun getAuthor(authorId: Int): ResponseEntity<AuthorInfo> {
        val result = this.authorService.get(authorId)
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

    override fun searchAuthor(name: String): ResponseEntity<List<AuthorRecord>> {
        val results = this.authorService.search(name)
        return ResponseEntity(results, HttpStatus.OK)
    }
}