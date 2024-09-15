package yoshibata.exam.quocard.libraryApp.service

import yoshibata.exam.quocard.libraryApp.controller.AuthorDto

interface AuthorService {
    fun get(id: Int): AuthorInfo
    fun post(dto: AuthorDto): Int
    fun put(id: Int, dto: AuthorDto)
    fun search(param: String): List<AuthorInfo>
}