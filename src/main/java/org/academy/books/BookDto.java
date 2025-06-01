package org.academy.books;

public class BookDto {
  // add fields for book data transfer object
  private String title;
  private String author;

  public BookDto() {
    // Default constructor
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public String toString() {
    return "BookDto{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
  }
}
