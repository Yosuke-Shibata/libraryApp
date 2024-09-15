package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.jooq.exception.NoDataFoundException
import org.jooq.generated.Tables.AUTHOR
import org.jooq.generated.tables.records.AuthorRecord
import org.springframework.stereotype.Repository


@Repository
class AuthorRepositoryImpl(private val dslContext: DSLContext) : AuthorRepository {

    override fun find(id: Int): AuthorRecord {
        val result = this.dslContext.selectFrom(AUTHOR).where(AUTHOR.ID.eq(id)).fetchAny()
        if (result !== null) return result else throw NoDataFoundException()
    }

    override fun create(dto: AuthorDto): Int {
        val result =
            this.dslContext.insertInto(AUTHOR, AUTHOR.NAME).values(dto.name).returningResult(AUTHOR.ID).fetchOne()
        if (result !== null) return result.value1() else throw DataAccessException("Insert failed.")
    }

    override fun update(id: Int, dto: AuthorDto) {
        this.dslContext.update(AUTHOR).set(AUTHOR.NAME, dto.name).where(AUTHOR.ID.eq(id)).execute()
    }

    override fun search(param: String): List<AuthorRecord> {
        return this.dslContext.selectFrom(AUTHOR).where(AUTHOR.NAME.like(param)).fetch()
    }
}