package yoshibata.exam.quocard.libraryApp.repository

import yoshibata.exam.quocard.libraryApp.jooq.tables.records.AuthorRecord
import yoshibata.exam.quocard.libraryApp.jooq.tables.records.BookRecord

interface WorkRepository {
    fun findBookByAuthorId(authorId: Int): List<BookRecord>

    fun findAuthorByBookId(bookId: Int): List<AuthorRecord>

    fun create(
        authorId: Int,
        bookId: Int,
    )
}
