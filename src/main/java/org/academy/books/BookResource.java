package org.academy.books;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.academy.books.utils.mappers.BookMapper;

@Path("/books")
@Produces({MediaType.APPLICATION_JSON})
public class BookResource {

  private final BookService bookService;

  @Inject
  public BookResource(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Retrieves a list of all books.
   *
   * @return a list of BookDto objects representing all books.
   */
  @GET
  public List<BookDto> getBooks() {
    return bookService.getAllBooks();
  }

  @GET
  @Path("/hello")
  public String hello() {
    return "Hello, Book Resource!";
  }

  @GET
  @Path("/{id}")
  public BookDto getBookById(@PathParam("id") Long id) {
    return bookService.getBookById(id);
  }

  @POST
  public void createBook(BookDto book) {
    bookService.createBook(BookMapper.toEntity(book));
  }

  @DELETE
  public void deleteBookById(@QueryParam("id") Long id) {
    if (id == null) {
      throw new BadRequestException("ID must be provided for deletion.");
    }
    bookService.deleteBookById(id);
  }
}
