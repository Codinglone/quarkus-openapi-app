package org.academy.books.utils.mappers;

import org.academy.books.BookDto;
import org.academy.books.BookEntity;

public class BookMapper {

  private BookMapper() {
    // Private constructor to prevent instantiation
  }

  public static BookEntity toEntity(BookDto bookDTO) {
    if (bookDTO == null) {
      return null;
    }
    BookEntity entity = new BookEntity();
    entity.setTitle(bookDTO.getTitle());
    entity.setAuthor(bookDTO.getAuthor());
    return entity;
  }

  public static BookDto toModel(BookEntity bookEntity) {
    if (bookEntity == null) {
      return null;
    }
    BookDto bookDTO = new BookDto();
    bookDTO.setTitle(bookEntity.getTitle());
    bookDTO.setAuthor(bookEntity.getAuthor());
    return bookDTO;
  }
}
