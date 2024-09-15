package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.generated.tables.records.AuthorRecord
import org.jooq.generated.tables.records.BookRecord

interface WorkRepository {
    fun findBookByAuthorId(authorId: Int): List<BookRecord>

    fun findAuthorByBookId(bookId: Int): List<AuthorRecord>

    fun create(
        authorId: Int,
        bookId: Int,
    )
}
