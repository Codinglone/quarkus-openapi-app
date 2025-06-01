package org.academy.books;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.academy.books.utils.mappers.BookMapper;

@Transactional
@ApplicationScoped
public class BookService {

  private final BookRepository bookRepository;

  @Inject
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  // Add methods for business logic related to books here

  public void createBook(BookEntity book) {
    bookRepository.persist(book);
  }

  public List<BookDto> getAllBooks() {
    return bookRepository.listAll().stream().map(BookMapper::toModel).toList();
  }

  public BookDto getBookById(Long id) {
    return bookRepository
        .findByIdOptional(id)
        .map(BookMapper::toModel)
        .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
  }

  public void deleteBookById(Long id) {
    if (bookRepository.findById(id) == null) {
      throw new EntityNotFoundException("Book not found with id: " + id);
    }
    bookRepository.deleteById(id);
  }
}
