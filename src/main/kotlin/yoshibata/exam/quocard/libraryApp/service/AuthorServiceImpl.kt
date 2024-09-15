package yoshibata.exam.quocard.libraryApp.service

import org.springframework.stereotype.Service
import yoshibata.exam.quocard.libraryApp.controller.AuthorDto
import yoshibata.exam.quocard.libraryApp.repository.AuthorRepository

@Service
class AuthorServiceImpl(private val authorRep: AuthorRepository) : AuthorService {
    override fun get(id: Int): AuthorInfo {
        val authorResult = this.authorRep.find(id)
        return AuthorInfo(id, authorResult.name)
    }

    override fun post(dto: AuthorDto): Int {
        return this.authorRep.create(dto)
    }

    override fun put(id: Int, dto: AuthorDto) {
        this.authorRep.update(id, dto)
    }

    override fun search(param: String): List<AuthorInfo> {
        val authorResults = this.authorRep.search(param)
        return authorResults.map { item -> AuthorInfo(item.id, item.name) }
    }
}

data class AuthorInfo(val id: Int, val name: String)
