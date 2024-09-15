package yoshibata.exam.quocard.libraryApp.service

interface BookService {
    fun get(id: Int): BookInfo
    fun post(title: String): Int
    fun put(id: Int, title: String)
    fun search(param: String): List<BookInfo>
}