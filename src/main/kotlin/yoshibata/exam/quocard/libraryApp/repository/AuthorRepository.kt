package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.generated.tables.records.AuthorRecord

interface AuthorRepository {
    fun find(id: Int): AuthorRecord
    fun create(dto: AuthorDto): Int
    fun update(id: Int, dto: AuthorDto)
    fun search(param: String): List<AuthorRecord>
}

data class AuthorDto(val name: String)