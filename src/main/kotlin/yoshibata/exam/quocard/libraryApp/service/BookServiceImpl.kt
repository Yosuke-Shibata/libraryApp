package yoshibata.exam.quocard.libraryApp.service

import org.springframework.stereotype.Service
import yoshibata.exam.quocard.libraryApp.repository.BookRepository

@Service
class BookServiceImpl(private val bookRep: BookRepository) : BookService {
    override fun get(id: Int): BookInfo {
        val bookResult = this.bookRep.find(id)
        return BookInfo(id, bookResult.title)
    }

    override fun post(title: String): Int {
        return this.bookRep.create(title)
    }

    override fun put(id: Int, title: String) {
        this.bookRep.update(id, title)
    }

    override fun search(param: String): List<BookInfo> {
        val bookResults = this.bookRep.search(param)
        return bookResults.map { item -> BookInfo(item.id, item.title) }
    }
}

data class BookInfo(val id: Int, val title: String)