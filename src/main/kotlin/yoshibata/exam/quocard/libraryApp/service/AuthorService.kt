package yoshibata.exam.quocard.libraryApp.service

interface AuthorService {
    fun get(id: Int): AuthorInfo
    fun post(name: String): Int
    fun put(id: Int, name: String)
    fun search(param: String): List<AuthorInfo>
}