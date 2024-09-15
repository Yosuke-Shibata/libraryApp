package yoshibata.exam.quocard.libraryApp.service

import org.springframework.stereotype.Service
import yoshibata.exam.quocard.libraryApp.repository.WorkRepository

@Service
class WorkServiceImpl(private val workRep: WorkRepository) : WorkService {
    override fun getBooks(authorId: Int): List<BookInfo> {
        val results = this.workRep.findBookByAuthorId(authorId)
        return results.map { item -> BookInfo(item.id, item.title) }
    }

    override fun getAuthors(bookId: Int): List<AuthorInfo> {
        val results = this.workRep.findAuthorByBookId(bookId)
        return results.map { item -> AuthorInfo(item.id, item.name) }
    }

    override fun post(authorId: Int, bookId: Int) {
        this.workRep.create(authorId, bookId)
    }
}