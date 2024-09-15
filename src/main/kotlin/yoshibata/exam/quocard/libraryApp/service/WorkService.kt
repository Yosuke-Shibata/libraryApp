package yoshibata.exam.quocard.libraryApp.service

interface WorkService {
    fun getBooks(authorId: Int): List<BookInfo>
    fun getAuthors(bookId: Int): List<AuthorInfo>
    fun post(authorId: Int, bookId: Int)
}