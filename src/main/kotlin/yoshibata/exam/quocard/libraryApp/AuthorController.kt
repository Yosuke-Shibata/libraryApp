package yoshibata.exam.quocard.libraryApp

import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/book")
interface AuthorController {
  @GetMapping("{authorId}")
  fun getAuthor(
    @PathVariable authorId: Int,
  )

  @PostMapping("")
  fun postAuthor(
    @RequestBody author: Author,
  ): Int

  @PutMapping("{authorId}")
  fun putAuthor(
    @RequestBody author: Author,
  )

  @DeleteMapping("{authorId}")
  fun deleteAuthor(
    @PathVariable authorId: Int,
  )
}
