package yoshibata.exam.quocard.libraryApp.repository

import yoshibata.exam.quocard.libraryApp.JOOQ.tables.records.AuthorRecord

interface AuthorRepository {
    fun find(id: Int): AuthorRecord

    fun create(name: String): Int

    fun update(
        id: Int,
        name: String,
    ): Boolean

    fun delete(id: Int): Boolean

    fun search(param: String): List<AuthorRecord>
}
