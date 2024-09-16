package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.jooq.exception.NoDataFoundException
import org.jooq.generated.Tables.BOOK
import org.jooq.generated.tables.records.BookRecord
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(private val dslContext: DSLContext) : BookRepository {
    override fun find(id: Int): BookRecord {
        val result = this.dslContext.selectFrom(BOOK).where(BOOK.ID.eq(id)).fetchAny()
        if (result !== null) return result else throw NoDataFoundException()
    }

    override fun create(bookDto: BookDto): Int {
        val result =
            this.dslContext.insertInto(BOOK, BOOK.TITLE).values(bookDto.title).returningResult(BOOK.ID).fetchOne()
        if (result !== null) return result.value1() else throw DataAccessException("Insert failed.")
    }

    override fun update(id: Int, bookDto: BookDto) {
        this.dslContext.update(BOOK).set(BOOK.TITLE, bookDto.title).where(BOOK.ID.eq(id)).execute()
    }

    override fun search(param: String): List<BookRecord> {
        return this.dslContext.selectFrom(BOOK).where(BOOK.TITLE.like("%${param}%")).fetch()
    }
}