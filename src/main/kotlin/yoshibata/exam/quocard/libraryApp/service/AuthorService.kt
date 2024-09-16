package yoshibata.exam.quocard.libraryApp.service

import yoshibata.exam.quocard.libraryApp.repository.AuthorDto

interface AuthorService {
    fun get(id: Int): AuthorInfo
    fun post(dto: AuthorDto): Int
    fun put(id: Int, dto: AuthorDto)
    fun search(param: String): List<SearchAuthorInfo>
}

data class AuthorInfo(val id: Int, val name: String, val books: List<String>)
data class SearchAuthorInfo(val id: Int, val name: String)