package yoshibata.exam.quocard.libraryApp.repository

import yoshibata.exam.quocard.libraryApp.JOOQ.tables.records.BookRecord

interface BookRepository {
    fun find(id: Int): BookRecord

    fun create(title: String): Int

    fun update(
        id: Int,
        title: String,
    ): Boolean

    fun delete(id: Int): Boolean

    fun search(param: String): List<BookRecord>
}
