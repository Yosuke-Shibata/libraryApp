package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.generated.tables.records.BookRecord

interface BookRepository {
    fun find(id: Int): BookRecord
    fun create(bookDto: BookDto): Int
    fun update(id: Int, bookDto: BookDto)
    fun search(param: String): List<BookRecord>
}

data class BookDto(val title: String, val authorIds: List<Int>)