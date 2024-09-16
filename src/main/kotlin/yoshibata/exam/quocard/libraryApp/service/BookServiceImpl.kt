package yoshibata.exam.quocard.libraryApp.service

import org.springframework.stereotype.Service
import yoshibata.exam.quocard.libraryApp.repository.BookDto
import yoshibata.exam.quocard.libraryApp.repository.BookRepository
import yoshibata.exam.quocard.libraryApp.repository.WorkRepository

@Service
class BookServiceImpl(private val bookRep: BookRepository, private val workRep: WorkRepository) : BookService {
    override fun get(id: Int): BookInfo {
        val bookResult = this.bookRep.find(id)
        val workResult = this.workRep.findAuthorByBookId(id)
        return BookInfo(id, bookResult.title, workResult.map { item -> item.name })
    }

    override fun post(bookDto: BookDto): Int {
        val bookId = this.bookRep.create(bookDto)
        bookDto.authorIds.forEach { authorId -> this.workRep.create(authorId, bookId) }
        return bookId
    }

    override fun put(id: Int, bookDto: BookDto) {
        this.bookRep.update(id, bookDto)
    }

    override fun search(param: String): List<SearchBookInfo> {
        val results = this.bookRep.search(param)
        return results.map { item -> SearchBookInfo(item.id, item.title) }
    }
}

