package yoshibata.exam.quocard.libraryApp.repository

import yoshibata.exam.quocard.libraryApp.JOOQ.tables.records.WorkRecord

interface WorkRepository {
    fun findByAuthorId(authorId: Int): List<WorkRecord>

    fun findByBookId(bookId: Int): List<WorkRecord>

    fun createWork(
        authorId: Int,
        bookId: Int,
    ): Int
}
