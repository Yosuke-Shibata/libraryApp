package yoshibata.exam.quocard.libraryApp.service

import org.springframework.stereotype.Service
import yoshibata.exam.quocard.libraryApp.repository.AuthorDto
import yoshibata.exam.quocard.libraryApp.repository.AuthorRepository
import yoshibata.exam.quocard.libraryApp.repository.WorkRepository

@Service
class AuthorServiceImpl(private val authorRep: AuthorRepository, private val workRep: WorkRepository) : AuthorService {
    override fun get(id: Int): AuthorInfo {
        val authorResult = this.authorRep.find(id)
        val workResult = this.workRep.findBookByAuthorId(id)
        return AuthorInfo(id, authorResult.name, workResult.map { item -> item.title })
    }

    override fun post(dto: AuthorDto): Int {
        return this.authorRep.create(dto)
    }

    override fun put(id: Int, dto: AuthorDto) {
        this.authorRep.update(id, dto)
    }

    override fun search(param: String): List<SearchAuthorInfo> {
        val results = this.authorRep.search(param)
        return results.map { item -> SearchAuthorInfo(item.id, item.name) }
    }
}