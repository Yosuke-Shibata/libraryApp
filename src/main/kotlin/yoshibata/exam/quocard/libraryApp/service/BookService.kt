package yoshibata.exam.quocard.libraryApp.service

import org.jooq.generated.tables.records.BookRecord
import yoshibata.exam.quocard.libraryApp.repository.BookDto

interface BookService {
    fun get(id: Int): BookInfo
    fun post(bookDto: BookDto): Int
    fun put(id: Int, bookDto: BookDto)
    fun search(param: String): List<BookRecord>
}

data class BookInfo(val id: Int, val title: String, val author: List<String>)