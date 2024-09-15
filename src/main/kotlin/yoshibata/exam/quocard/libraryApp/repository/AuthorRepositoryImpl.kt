package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.jooq.exception.NoDataFoundException
import org.springframework.stereotype.Repository
import yoshibata.exam.quocard.libraryApp.jooq.Tables.AUTHOR
import yoshibata.exam.quocard.libraryApp.jooq.tables.records.AuthorRecord


@Repository
class AuthorRepositoryImpl(private val dslContext: DSLContext) : AuthorRepository {

    override fun find(id: Int): AuthorRecord {
        val result = this.dslContext.selectFrom(AUTHOR).where(AUTHOR.ID.eq(id)).fetchAny()
        if (result !== null) return result else throw NoDataFoundException()
    }

    override fun create(name: String): Int {
        val result = this.dslContext.insertInto(AUTHOR, AUTHOR.NAME).values(name).returningResult(AUTHOR.ID).fetchOne()
        if (result !== null) return result.value1() else throw DataAccessException("Insert failed.")
    }

    override fun update(id: Int, name: String) {
        this.dslContext.update(AUTHOR).set(AUTHOR.NAME, name).where(AUTHOR.ID.eq(id)).execute()
    }

    override fun search(param: String): List<AuthorRecord> {
        return this.dslContext.selectFrom(AUTHOR).where(AUTHOR.NAME.like(param)).fetch()
    }
}