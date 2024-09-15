package yoshibata.exam.quocard.libraryApp.repository

import org.jooq.DSLContext
import org.jooq.generated.Tables.*
import org.jooq.generated.tables.records.AuthorRecord
import org.jooq.generated.tables.records.BookRecord
import org.springframework.stereotype.Repository

@Repository
class WorkRepositoryImpl(private val dslContext: DSLContext) : WorkRepository {
    override fun findBookByAuthorId(authorId: Int): List<BookRecord> {
        return this.dslContext
            .select(BOOK.ID, BOOK.TITLE)
            .from(BOOK)
            .join(WORK).on(BOOK.ID.eq(WORK.BOOK_ID))
            .where(
                WORK.AUTHOR_ID.eq(authorId),
            )
            .fetch()
            .into(BOOK)
    }

    override fun findAuthorByBookId(bookId: Int): List<AuthorRecord> {
        return this.dslContext
            .select(AUTHOR.ID, AUTHOR.NAME)
            .from(AUTHOR)
            .join(WORK).on(AUTHOR.ID.eq(WORK.AUTHOR_ID))
            .where(
                WORK.BOOK_ID.eq(bookId),
            )
            .fetch()
            .into(AUTHOR)
    }

    override fun create(
        authorId: Int,
        bookId: Int,
    ) {
        this.dslContext
            .insertInto(WORK, WORK.AUTHOR_ID, WORK.BOOK_ID)
            .values(authorId, bookId).onDuplicateKeyIgnore()
            .execute()
    }
}
