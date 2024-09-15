package yoshibata.exam.quocard.libraryApp.repository

import yoshibata.exam.quocard.libraryApp.jooq.tables.records.AuthorRecord

interface AuthorRepository {
    fun find(id: Int): AuthorRecord

    fun create(name: String): Int

    fun update(id: Int, name: String)

    fun search(param: String): List<AuthorRecord>
}
