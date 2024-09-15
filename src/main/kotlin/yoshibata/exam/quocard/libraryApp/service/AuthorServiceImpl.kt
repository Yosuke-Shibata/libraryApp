package yoshibata.exam.quocard.libraryApp.service

import org.springframework.stereotype.Service
import yoshibata.exam.quocard.libraryApp.repository.AuthorRepository

@Service
class AuthorServiceImpl(private val authorRep: AuthorRepository) : AuthorService {
    override fun get(id: Int): AuthorInfo {
        val authorResult = authorRep.find(id)
        return AuthorInfo(id, authorResult.name)
    }

    override fun post(name: String): Int {
        return authorRep.create(name)
    }

    override fun put(id: Int, name: String) {
        authorRep.update(id, name)
    }

    override fun search(param: String): List<AuthorInfo> {
        val authorResults = authorRep.search(param)
        return authorResults.map { item -> AuthorInfo(item.id, item.name) }
    }
}

data class AuthorInfo(val id: Int, val name: String)
